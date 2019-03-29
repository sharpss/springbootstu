package com.llx.summer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.llx.summer.domain.User;
import com.llx.summer.web.UserController;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter311ApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
		RequestBuilder request = null;

		//1.get查一下user列表，
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
//				.andDo(print()) //打印出请求和相应的内容
				.andExpect(content().string(equalTo("[{\"id\":111,\"name\":\"张三\",\"age\":21},{\"id\":112,\"name\":\"李四\",\"age\":22}]")));
		//2.post提交一个user
         Map<String, String> map = new LinkedHashMap<>();
         map.put("id", "201");
         map.put("name", "测试者");
         map.put("age", "19");
        String content = JSONObject.toJSONString(map);

		request = post("/users/").contentType(MediaType.APPLICATION_JSON).content(content);
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("ok")));

		//3.get获取user列表，应该有刚才插入的数据

		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":111,\"name\":\"张三\",\"age\":21},{\"id\":112,\"name\":\"李四\",\"age\":22},{\"id\":201,\"name\":\"测试者\",\"age\":19}]")));

		//4.put修改id为1的user
		map.put("id", "");
		map.put("name", "测试者put");
		map.put("age", "30");
		content = JSONObject.toJSONString(map);

		request =put("/users/201").contentType(MediaType.APPLICATION_JSON).content(content);
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("ok")));
		//5.get一个id为201的user
		request=get("/users/201");
		mvc.perform(request)
				.andExpect(content().string(equalTo("{\"id\":201,\"name\":\"测试者put\",\"age\":30}")));

		//6.del删除id为201的user
		request = delete("/users/201");
		mvc.perform(request)
				.andExpect(content().string(equalTo("ok")));

		//7.get查询一下user列表
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":111,\"name\":\"张三\",\"age\":21},{\"id\":112,\"name\":\"李四\",\"age\":22}]")));
	}



}
