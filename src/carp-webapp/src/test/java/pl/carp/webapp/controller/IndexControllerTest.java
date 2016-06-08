package pl.carp.webapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.carp.webapp.base.BaseControllerTest;
import pl.carp.webapp.base.annotation.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.carp.webapp.TestConstant.TEXT_MEDIA_TYPE;

/**
 * Index REST Controller tests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ControllerTest
public class IndexControllerTest extends BaseControllerTest {

    @Test
    public void shouldDisplayIndexPage() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.parseMediaType(TEXT_MEDIA_TYPE)))
                .andExpect(status().isOk());
    }
}