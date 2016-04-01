//package co.za.repository;
//
//import java.util.List;
//
//import transie.Transport;
//import transie.TransportService;
//import transie.TransportServiceImpl;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.Assert.assertEquals;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(SampleDataJpaApplication.class)
//public class TransportServiceTest {
//	 
// 
//	private RepositoryPersonService personService;
//	 
//    private PersonRepository personRepositoryMock;
// 
//    @Before
//    public void setUp() {
//        personService = new RepositoryPersonService();
// 
//        personRepositoryMock = mock(PersonRepository.class);
//        personService.setPersonRepository(personRepositoryMock);
//    }
// 
//    @Test
//    public void searchWhenSearchTypeIsMethodName() {
//        SearchDTO searchCriteria = createSearchDTO(LAST_NAME, SearchType.METHOD_NAME);
//        List<Person> expected = new ArrayList<Person>();
//        when(personRepositoryMock.findByLastName(searchCriteria.getSearchTerm())).thenReturn(expected);
//         
//        List<Person> actual = personService.search(searchCriteria);
//         
//        verify(personRepositoryMock, times(1)).findByLastName(searchCriteria.getSearchTerm());
//        verifyNoMoreInteractions(personRepositoryMock);
//         
//        assertEquals(expected, actual);
//    }
//private RestTemplate restTemplate = new TestRestTemplate();
//02
//	 
//03
//	@Test
//04
//	public void getsOwner() {
//05
//	    String ownerUrl = "http://localhost:9000/owners/1";
//06
//	 
//07
//	    ParameterizedTypeReference<Resource<Owner>> responseType = new ParameterizedTypeReference<Resource<Owner>>() {};
//08
//	 
//09
//	    ResponseEntity<Resource<Owner>> responseEntity =
//10
//	            restTemplate.exchange(ownerUrl, GET, null, responseType);
//11
//	 
//12
//	    Owner owner = responseEntity.getBody().getContent();
//13
//	    assertEquals("George", owner.getFirstName());
//14
//	 
//15
//	    // more assertions
//16
//	 
//17
	//}
//}
