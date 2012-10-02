package com.bragi.sonify.composer.lsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class LSystemTest extends TestCase {
	
	private LSystem l;
	private Set<Character> vars;
	private Map<String, String> rulez;
	private String axiom;
	
	protected void setUp() {
		vars = new HashSet<Character>();
		rulez = new HashMap<String, String>();
		axiom = "a";
		
		vars.add('a');
		vars.add('b');
		
		rulez.put("a", "b");
		rulez.put("b", "(a)[b]");
		
		l = new LSystem( vars, axiom, rulez);
	}
	
	protected void tearDown() {
		vars = null;
		rulez = null;
		axiom = null;
		l = null;
	}
	
	public void testGenerate() {		
		assertEquals("a", l.generate(0));
		assertEquals("b", l.generate(1));
		assertEquals("(a)[b]", l.generate(2));
		assertEquals("(b)[(a)[b]]", l.generate(3));
		assertEquals("((a)[b])[(b)[(a)[b]]]", l.generate(4));
		assertEquals("((b)[(a)[b]])[((a)[b])[(b)[(a)[b]]]]", l.generate(5));
		assertEquals("(((a)[b])[(b)[(a)[b]]])[((b)[(a)[b]])[((a)[b])[(b)[(a)[b]]]]]", l.generate(6));
	}

}
