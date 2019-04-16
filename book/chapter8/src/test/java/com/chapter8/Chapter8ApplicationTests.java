package com.chapter8;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
//@JsonTest
public class Chapter8ApplicationTests {
    /**
     *
     */
//    @Resource
//    JacksonTester<Book> jacksonTester;

//    @Autowired
//    TestRestTemplate restTemplate;


    @Autowired
    HelloService helloService;
//    @Autowired
//    WebApplicationContext wac;
//    MockMvc mockMvc;
//    @Before
//    public void before(){
//        mockMvc= MockMvcBuilders.standaloneSetup(wac).build();
//    }
//    @Test
//    public void contextLoads()throws Exception {
//        MvcResult mvcResult=mockMvc.perform(
//                MockMvcRequestBuilders.get("/hello")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("name","Michael"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println(mvcResult.getResponse().getContentAsString());
//
//    }
//
    @Test
    public void index(){
        String hello=helloService.sayHello("Michael");
        Assert.assertThat(hello, Matchers.is("Hello Michael !"));
    }
//
//
//
//    @Test
//    public void test2()throws Exception{
//        ObjectMapper om=new ObjectMapper();
//        Book book=new Book();
//        book.setAuthor("罗贯中");
//        book.setName("三国演义");
//        book.setId(1);
//        String s=om.writeValueAsString(book);
//        MvcResult mvcResult=mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/book")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(s))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//        System.out.println(mvcResult.getResponse().getContentAsString());
//
//    }


//    @Test
//    public void test3(){
//        ResponseEntity<String> hello=restTemplate.getForEntity("/hello?name={0}",String.class,"Michael");
//        System.out.println(hello.getBody());
//    }

//    @Test
//    public void testSerialize()throws Exception{
//        Book book=new Book();
//        book.setId(1);
//        book.setName("三国演义");
//        book.setAuthor("罗贯中");
//        Assertions.assertThat(jacksonTester.write(book))
//        .isEqualToJson("book.json");
//        Assertions.assertThat(jacksonTester.write(book))
//                .hasJsonPathStringValue("@.name");
//        Assertions.assertThat(jacksonTester.write(book))
//                .extractingJsonPathStringValue("@.name")
//                .isEqualTo("三国演义");
//    }
//
//
//    @Test
//    public void testDesc()throws Exception{
//        String content="{\"id\":1,\"name\":\"三国演义\",\"author\":\"罗贯中\"}";
//        Assertions.assertThat(jacksonTester.parseObject(content).getName()).isEqualTo("三国演义");
//    }


}
