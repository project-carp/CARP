package pl.carp.backend.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.carp.backend.configuration.annotation.DefaultWebTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static pl.carp.backend.TestConstant.MEDIA_TYPE;

/**
 * Index REST Controller tests
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@DefaultWebTest
public class IndexControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //@Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    //@Test
    public void shouldDisplayIndexPage() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.parseMediaType(MEDIA_TYPE)))
                .andExpect(status().isOk());
    }

    //@Test
    public void shouldNotDisplayLoginPage() throws Exception {
        mockMvc.perform(get("/loginPage")
                .accept(MediaType.parseMediaType(MEDIA_TYPE)))
                .andExpect(status().isNotFound());
    }
}
