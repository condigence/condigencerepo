//package net.digitmarketplace.vendor.rest;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.digitmarketplace.vendor.Application;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ProductControllerTest {
//
//	private MockMvc mockMvc;
//	
//	@Autowired
//    private WebApplicationContext wac;
//
//	@Before
//	public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//
//	}
//
//	@Test
//	public void verifyAllproductsList() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$", hasSize(4))).andDo(print());
//	}
//	
////	@Test
////	public void verifyproductsById() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.get("/products/3").accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.id").exists())
////		.andExpect(jsonPath("$.text").exists())
////		.andExpect(jsonPath("$.completed").exists())
////		.andExpect(jsonPath("$.id").value(3))
////		.andExpect(jsonPath("$.text").value("Build the artifacts"))
////		.andExpect(jsonPath("$.completed").value(false))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyInvalidproductsArgument() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.get("/products/f").accept(MediaType.APPLICATION_JSON))
////			.andExpect(jsonPath("$.errorCode").value(400))
////			.andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."))
////			.andDo(print());
////	}
////	
////	@Test
////	public void verifyInvalidproductsId() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.get("/products/0").accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.errorCode").value(404))
////		.andExpect(jsonPath("$.message").value("products doesn´t exist"))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyNullproducts() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.get("/products/6").accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.errorCode").value(404))
////		.andExpect(jsonPath("$.message").value("products doesn´t exist"))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyDeleteproducts() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.delete("/products/4").accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.status").value(200))
////		.andExpect(jsonPath("$.message").value("products has been deleted"))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyInvalidproductsIdToDelete() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.delete("/products/9").accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.errorCode").value(404))
////		.andExpect(jsonPath("$.message").value("products to delete doesn´t exist"))
////		.andDo(print());
////	}
////	
////	
////	@Test
////	public void verifySaveproducts() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.post("/products/")
////        .contentType(MediaType.APPLICATION_JSON)
////        .content("{\"text\" : \"New products Sample\", \"completed\" : \"false\" }")
////		.accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.id").exists())
////		.andExpect(jsonPath("$.text").exists())
////		.andExpect(jsonPath("$.completed").exists())
////		.andExpect(jsonPath("$.text").value("New products Sample"))
////		.andExpect(jsonPath("$.completed").value(false))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyMalformedSaveproducts() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.post("/products/")
////        .contentType(MediaType.APPLICATION_JSON)
////        .content("{ \"id\": \"8\", \"text\" : \"New products Sample\", \"completed\" : \"false\" }")
////		.accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.errorCode").value(404))
////		.andExpect(jsonPath("$.message").value("Payload malformed, id must not be defined"))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyUpdateproducts() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.patch("/products/")
////        .contentType(MediaType.APPLICATION_JSON)
////        .content("{ \"id\": \"1\", \"text\" : \"New products Text\", \"completed\" : \"false\" }")
////        .accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.id").exists())
////		.andExpect(jsonPath("$.text").exists())
////		.andExpect(jsonPath("$.completed").exists())
////		.andExpect(jsonPath("$.id").value(1))
////		.andExpect(jsonPath("$.text").value("New products Text"))
////		.andExpect(jsonPath("$.completed").value(false))
////		.andDo(print());
////	}
////	
////	@Test
////	public void verifyInvalidproductsUpdate() throws Exception {
////		mockMvc.perform(MockMvcRequestBuilders.patch("/products/")
////        .contentType(MediaType.APPLICATION_JSON)
////        .content("{ \"idd\": \"8\", \"text\" : \"New products Sample\", \"completed\" : \"false\" }")
////		.accept(MediaType.APPLICATION_JSON))
////		.andExpect(jsonPath("$.errorCode").value(404))
////		.andExpect(jsonPath("$.message").value("products to update doesn´t exist"))
////		.andDo(print());
////	}
//
//}
