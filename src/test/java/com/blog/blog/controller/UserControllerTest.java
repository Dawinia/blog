package com.blog.blog.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest
{

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Before
//    public void setup() {
//        System.out.println("set up");
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
//    }

    @BeforeEach
    void setUp()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void getAllUsers() throws Exception
    {
        mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andReturn();
    }

    @Test
    void getUsersByPage() throws Exception
    {
        mockMvc.perform(get("/user/?page=1&size=10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andReturn();
    }

    @Test
    void getUserById() throws Exception
    {
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andReturn();
    }

    @Test
    void deleteUserById() throws Exception
    {
        mockMvc.perform(delete("/user/4"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateUser() throws Exception
    {
        String param = "{\n"
                + "  \"id\": 3,\n"
                + "  \"username\": \"testupdate\",\n"
                + "  \"password\": \"pppp\",\n"
                + "  \"email\": \"test@email.com\",\n"
                + "  \"registerDate\": \"2020-3-17\"\n"
                + "}";
        mockMvc.perform(put("/user/").content(param.getBytes()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("testupdate"))
                .andReturn();
    }

    @Test
    void addUser() throws Exception
    {
        String param = "{\n"
                + "  \"username\": \"testadd\",\n"
                + "  \"password\": \"password\",\n"
                + "  \"email\": \"test@email.com\",\n"
                + "  \"registerDate\": \"2020-3-12\"\n"
                + "}";
        mockMvc.perform(post("/user/").content(param))
                .andExpect(status().isOk())
                .andReturn();
    }
}