import application.article.GameArticleService;
import application.gamecategory.GameCategoryService;
import infrastructure.controller.DashboardController;
import infrastructure.service.article.GameArticleServiceImpl;
import infrastructure.service.gamecategory.GameCategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Damian on 03.01.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DashboardControllerTest.Config.class)
public class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_dashboard_page() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Configuration
    static class Config{

        @Bean
        GameCategoryService serviceCategory(){
            return Mockito.mock(GameCategoryServiceImpl.class);
        }

        @Bean
        GameArticleService articleService(){
            return Mockito.mock(GameArticleServiceImpl.class);
        }

        @Bean
        DashboardController controller(GameCategoryService serviceCategory,GameArticleService articleService){
            return new DashboardController(serviceCategory,articleService);
        }

        @Bean
        MockMvc mockMvc (DashboardController dashboardController){
            return MockMvcBuilders
                    .standaloneSetup(dashboardController)
                    .build();
        }
    }
}
