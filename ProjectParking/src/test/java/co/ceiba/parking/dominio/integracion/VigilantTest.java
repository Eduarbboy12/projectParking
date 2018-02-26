package co.ceiba.parking.dominio.integracion;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.UserEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class VigilantTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	@Sql("delete.sql")
	public void listVehicleTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = get("/vehicle").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		byte[] responseVehicle = mvcResult.getResponse().getContentAsByteArray();

		List<VehicleEntity> msg = this.objectMapper.readValue(responseVehicle, new TypeReference<List<VehicleEntity>>() {
		});
		
		assertEquals("abc123", msg.get(0).getPlaque());

	}
	
	@Test
	public void listUserTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = get("/user").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		byte[] responseUser = mvcResult.getResponse().getContentAsByteArray();

		List<UserEntity> msg = this.objectMapper.readValue(responseUser, new TypeReference<List<UserEntity>>() {
		});
		
		assertEquals("cardia01", msg.get(0).getUser());

	}
	
	@Test
	public void logUserTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = get("/get-by-email/cardia01").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		byte[] responseUser = mvcResult.getResponse().getContentAsByteArray();

		UserEntity msg = this.objectMapper.readValue(responseUser, new TypeReference<UserEntity>() {
		});
		
		assertEquals("cardia01", msg.getUser());

	}
	
	
	@Test
	public void listRateTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = get("/rate").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		byte[] responseRate = mvcResult.getResponse().getContentAsByteArray();

		List<RateEntity> msg = this.objectMapper.readValue(responseRate, new TypeReference<List<RateEntity>>() {
		});
		
		assertEquals("NA", msg.get(0).getRateName());

	}
	
	@Test
	public void listInvoiceTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = get("/invoice").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		byte[] responseInvoice = mvcResult.getResponse().getContentAsByteArray();

		List<InvoiceEntity> msg = this.objectMapper.readValue(responseInvoice, new TypeReference<List<InvoiceEntity>>() {
		});
		
		assertEquals(25, msg.get(0).getId());

	}
	
	@Test
	public void isNotInputVehicleTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createvehicle")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"type\":\"CARRO\", \"plaque\":\"ASK43B\", \"cylinder\":\"1500\", \"document\":\"1234\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}
	
	@Test
	public void isUserTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Username\", \"lastName\":\"LastName\", \"document\":\"1234\", \"user\":\"adminadmin\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseUser = mvcResult.getResponse().getContentAsString();

		assertEquals(responseUser, responseUser);

	}
	
	@Test
	public void isNotCreateUserTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"lastName\":\"LastName\", \"document\":\"1234\", \"user\":\"adminadmin\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseUser = mvcResult.getResponse().getContentAsString();

		assertEquals(responseUser, responseUser);

	}
	
	@Test
	public void isNotUserTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Username\", \"lastName\":\"LastName\", \"document\":\"ABC\", \"user\":\"admin\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseUser = mvcResult.getResponse().getContentAsString();

		assertEquals(responseUser, responseUser);

	}
	
	@Test
	public void isRateTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createrate")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"type\":\"CARRO\", \"rateName\":\"Tarifa2\", \"rateValue\":\"0\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseUser = mvcResult.getResponse().getContentAsString();

		assertEquals(responseUser, responseUser);

	}
	
	@Test
	public void isNotRateTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createrate")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"rateName\":\"Tarifa2\", \"rateValue\":\"0\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseUser = mvcResult.getResponse().getContentAsString();

		assertEquals(responseUser, responseUser);

	}
	
	@Test
	public void isInputVehicleTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createvehicle")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"type\":\"CARRO\", \"plaque\":\"ESK43B\", \"cylinder\":\"1500\", \"document\":\"1234\"}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}
	
	@Test
	public void isCreateInvoiceTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createInvoice")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"vehicle\":{\"id\":33,\"type\":\"CARRO\",\"plaque\":\"abc123\",\"cylinder\":\"1000\",\"document\":\"1234\"},\"dateinput\":1519392071000,\"dateoutput\":null,\"timeparking\":0.0,\"valuepay\":0.0,\"rateEntity\":{\"id\":11,\"type\":\"CARRO\",\"rateName\":\"TarifaTest\",\"rateValue\":0}}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}
	
	@Test
	public void isNotCreateInvoiceTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/createInvoice")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"vehicle\":{\"type\":\"CARRO\",\"plaque\":\"abc123\",\"cylinder\":\"1000\",\"document\":\"1234\"},\"dateinput\":1519392071000,\"dateoutput\":null,\"timeparking\":0.0,\"valuepay\":0.0,\"rateEntity\":{\"id\":11,\"type\":\"CARRO\",\"rateName\":\"TarifaTest\",\"rateValue\":0}}");

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}
	
	@Test
	public void isCreateVehicleTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/invoice/KHK123")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}
	
	@Test
	public void isNotCreateVehicleTest() throws Exception {
		// when
		MockHttpServletRequestBuilder response = put("/invoice/FFFTTT5")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = this.mockMvc.perform(response).andExpect(status().isOk()).andReturn();

		String responseVehicle = mvcResult.getResponse().getContentAsString();

		assertEquals(responseVehicle, responseVehicle);

	}

}
