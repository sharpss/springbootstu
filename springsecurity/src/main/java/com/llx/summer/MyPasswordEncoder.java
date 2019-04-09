package com.llx.summer;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Auther: sharps
 * @Date: 19-4-2 15:48
 * @Description:
 */
public class MyPasswordEncoder implements PasswordEncoder{
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("\n\nstring:"+charSequence.toString());
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
