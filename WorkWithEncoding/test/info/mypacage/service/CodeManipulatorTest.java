package info.mypacage.service;

import static org.junit.Assert.*;

import org.junit.Test;

import info.mypackage.service.CodeManipulator;

public class CodeManipulatorTest {

	@Test
	public void testGetModifiedText() {
		assertEquals("ABCDE", CodeManipulator.getModifiedText("12Ab3c4D56 e"));
	}

}
