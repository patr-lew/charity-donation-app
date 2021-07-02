package pl.coderslab.charity.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.security.CustomUserDetailsService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @MockBean
    private InstitutionService institutionService;

    @MockBean
    private UserDetailsService mockUDS;

    @Autowired
    private MockMvc mockMvc;

    private final String urlPrefix = "/admin";

    @BeforeEach
    void setUp() {
        Mockito.clearInvocations(institutionService);
    }

    @WithMockUser(roles = "ROLE_ADMIN")
    @Test
    void whenGivingValidInstitutionId_returnTheView() throws Exception {
        final long institutionId = 18L;
        final String endpoint = urlPrefix + "/institution/" + institutionId;
        Institution testInstitution = new Institution();
        Mockito.when(institutionService.findById(anyLong())).thenReturn(testInstitution);

        mockMvc.perform(MockMvcRequestBuilders.get(endpoint))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(view().name("admin/editInstitution"));
    }
}