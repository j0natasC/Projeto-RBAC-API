package com.jonatas.rbac_api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerSecurityTest {

    @Autowired
    private MockMvc MockMvc;

    @Test
    @DisplayName("Deve retornar 200 ok quando usuario ADMIN acessa")
    @WithMockUser(username = "admin", roles = { "ADMIN" })

    void devePermitirAcessoAdmin() throws Exception {
        MockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
    }

}
