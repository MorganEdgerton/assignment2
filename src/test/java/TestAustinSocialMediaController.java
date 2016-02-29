import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class TestAustinSocialMediaController {
	
	AustinSocialMediaController mediaController = new AustinSocialMediaController();
	CounterService mockCounter = null;
	
	@Before
	public void setUp1() {		
		mockCounter = mock(CounterService.class);		
		mediaController.setCounterService(mockCounter);
	}
	
	@Test
	public void thisAlwaysPasses() {
    }
	
	@Test
	public void testHelloWorld() {
		String reply = mediaController.helloWorld();
		assertEquals("Hello world!", reply);
	}
		
	@Test
	public void testFindMediaCountTypeNotFoundTest() {
		Map <String,String> testMap = new HashMap<String,String>();
		ModelMap testModel = new ModelMap();
		testMap.put("typestats", "testTitle");
		TypeOutput testTypeOutput = new TypeOutput("testTitle", 0);
		when(mockCounter.countType("testTitle")).thenReturn(testTypeOutput);
		TypeOutput mediaCountOutput = (TypeOutput) mediaController.findMediaCount(testMap, testModel);
		assertEquals(testTypeOutput, mediaCountOutput); 
		verify(mockCounter).countType("testTitle");
	}
	
	@Test
	public void testFindMediaCountTypeFoundTest() {
		Map <String,String> testMap = new HashMap<String,String>();
		ModelMap testModel = new ModelMap();
		testMap.put("typestats", "INSTAGRAM");
		TypeOutput testTypeOutput = new TypeOutput("INSTAGRAM", 9);
		when(mockCounter.countType("INSTAGRAM")).thenReturn(testTypeOutput);
		TypeOutput mediaCountOutput = (TypeOutput) mediaController.findMediaCount(testMap, testModel);
		assertEquals(testTypeOutput, mediaCountOutput); 
		verify(mockCounter).countType("INSTAGRAM");
	}
	
	
	@Test
	public void testFindMediaCountAccountNotFoundTest() {
		Map <String,String> testMap = new HashMap<String,String>();
		ModelMap testModel = new ModelMap();
		testMap.put("accountstats", "testTitle");
		AccountOutput testAccountOutput = new AccountOutput("testTitle", 0);
		when(mockCounter.countAccount("testTitle")).thenReturn(testAccountOutput);
		AccountOutput mediaCountOutput = (AccountOutput) mediaController.findMediaCount(testMap, testModel);
		assertEquals(testAccountOutput, mediaCountOutput); 
		verify(mockCounter).countAccount("testTitle");
	}
	
	@Test
	public void testFindMediaCountAccountFoundTest() {
		Map <String,String> testMap = new HashMap<String,String>();
		ModelMap testModel = new ModelMap();
		testMap.put("accountstats", "AE");
		AccountOutput testAccountOutput = new AccountOutput("AE", 6);
		when(mockCounter.countAccount("AE")).thenReturn(testAccountOutput);
		AccountOutput mediaCountOutput = (AccountOutput) mediaController.findMediaCount(testMap, testModel);
		assertEquals(testAccountOutput, mediaCountOutput); 
		verify(mockCounter).countAccount("AE");
	}
//	@Test
//	public void testGetGreetingCorrectActionCompose() {
//		when(mockEditor.composeEmail()).thenReturn("test email");
//		String reply = emailController.getGreeting("compose");
//		assertEquals("test email", reply);
//		verify(mockEditor).thisIsVoidFunction();
//	}
//	
//	@Test
//	public void testGetGreetingCorrectActionCreate() {
//		when(mockEditor.composeEmail()).thenReturn("test email");
//		String reply = emailController.getGreeting("create");
//		assertEquals("test email", reply);
//	}
//		
//	@Test
//	public void testGetGreetingCorrectActionCapital() {
//		when(mockEditor.composeEmail()).thenReturn("test email");
//		String reply = emailController.getGreeting("COMPOSE");
//		assertEquals("test email", reply);
//	}
//		
//	@Test
//	public void testGetGreetingIncorrectAction() {
//		String reply = emailController.getGreeting("ajdfksdhj");
//		assertEquals("", reply);
//		verify(mockEditor, never()).composeEmail();
//	}
//	
//	@Test
//	public void testGetGreetingNullAction() {
//		String reply = emailController.getGreeting(null);
//		assertEquals("", reply);
//		verify(mockEditor, never()).composeEmail();		
//	}
//	
//	@Test
//	public void testWithGhostObject() {
//		when(mockEditor.composeEmail()).thenReturn("test email");		
//		String reply = emailController.getWithGhostEditor();
//		assertEquals("test email", reply);		
//	}	
}
