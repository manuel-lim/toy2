package com.sktelecom.study.java.toy2.web;

import com.sktelecom.study.java.toy2.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class, excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
})
public class HelloControllerTest {
    @Autowired
    MockMvc mvc;

    @WithMockUser(roles = "USER")
    @Test
    public void hello_가_리턴한다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
