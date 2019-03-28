package com.llx.summer;

import com.llx.summer.service.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter211ApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void contextLoads() {
		Assert.assertEquals("summer",blogProperties.getName());
		Assert.assertEquals(blogProperties.getTitle(),"spring boot学习");

		System.out.println("\n\n\n" + blogProperties.getDesc());
		System.out.println("blog的值：" + blogProperties.getValue());
		System.out.println("blog的ID：" + blogProperties.getUuid());
		System.out.println("blog的数量：" + blogProperties.getNumber() + "\n\n\n");
	}

}
