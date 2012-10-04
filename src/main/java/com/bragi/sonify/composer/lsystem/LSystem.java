/*******************************************************************************
 * Copyright (c) 2012 BragiSoft, Inc.
 * This source is subject to the BragiSoft Permissive License.
 * Please see the License.txt file for more information.
 * All other rights reserved.
 * 
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Contributors:
 * Jan-Christoph Klie - Everything
 * 
 *******************************************************************************/

package com.bragi.sonify.composer.lsystem;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * An L-System is a mathematical structure, namely a variant of a formal
 * grammar. It is very similar to a semi-Thue system. 
 * 
 * It consists of a tuple G = (V, ω, P):
 * 
 * V (the alphabet): is a set of symbols containing elements that can be
 * replaced (variables)
 * 
 * ω (start, axiom or initiator): is a string of symbols from V defining the
 * initial state of the system
 * 
 * P is a set of production rules or productions defining the way variables can
 * be replaced with combinations of constants and other variables. A production
 * consists of two strings, the predecessor and the successor. For any symbol A
 * in V which does not appear on the left hand side of a production in P, the
 * identity production A → A is assumed; these symbols are called constants or
 * terminals.
 */
public class LSystem {
	
	private Log log = LogFactory.getLog(LSystem.class);
	
	/**
	 * The set of symbols which can be replaced by the given rules.
	 */
	private Set<Character> alphabet;
	
	/**
	 * The initial state of the system; from it, the process of applying rules starts.
	 */
	private final String axiom;
	
	/**
	 * The map of rules which state how the variables  are replaced. Key is the value
	 * to replace, value the replacement itself.
	 */
	private Map<String, String> rules;		

	/**
	 * 
	 * @param alphabet The set of symbols which can be replaced by the given rules.
	 * @param axiom The initial state of the system; from it, the process of applying rules starts.
	 * @param rules The set of rules which state how the variables  are replaced.
	 */
	public LSystem(Set<Character> alphabet, String axiom, Map<String, String> rules) {
		this.alphabet = alphabet;
		this.axiom = axiom;
		this.rules = rules;
	}
	
	/**
	 * Creates a generation of the string starting with AXIOM (generation = 0) and returns it.
	 * In every generating step, every possible replacement is performed. If there is no rule
	 * for a symbol, it is seen as constant and not touched, just added to the intermediate result.
	 * After finishing, it returns the word of the given generation.
	 * 
	 * @param generations The generation of the word asked for:
	 * generation == 0: the resulting word is the axiom
	 * generation > 0:  the resulting word is the word of the generation'th generation
	 * generation < 0: not allowed
	 * 
	 * @return The generation of the word asked for
	 */
	public String generate( int generations) {
		
		if(generations < 0) {
			throw new IllegalArgumentException("Generations cannot be negative! Was " + generations);
		}
		
		String state = axiom;
		
		for(int i = 0; i < generations; i++) {
			state = nextStep(state);
			log.debug(state);
		}
		
		return state;
	}	
	
	/**
	 * Creates the next generation of a word from the input given by currentState.
	 * @param currentState The current state to work with
	 * @return The next generation of the word
	 */
	private String nextStep(String currentState) {
		
		StringBuilder sb = new StringBuilder();
		
		for(char c : currentState.toCharArray()) {
			if( rules.containsKey(Character.toString(c))) {
				sb.append( rules.get(Character.toString(c)));
			} else {
				sb.append(Character.toString(c));
			}
		}
		
		return sb.toString();
		
	}

	@Override
	public String toString() {
		return String.format("Alphabet:\t%s\nAxiom:\t\t%s\nRules:\t\t%s\n", alphabet, axiom, rules );
	}

}
