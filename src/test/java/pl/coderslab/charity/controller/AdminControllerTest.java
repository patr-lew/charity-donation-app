package pl.coderslab.charity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import pl.coderslab.charity.service.InstitutionService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @MockBean
    private InstitutionService institutionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGivingValidInstitutionId_returnTheView() throws Exception{
        final long instutitionId = 18L;
        final String endpoint = "/institution/" + instutitionId;
        mockMvc.perform(MockMvcRequestBuilders.get(endpoint))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
//                .andExpect(view().name("admin/editInstitution"))
                ;
    }
}