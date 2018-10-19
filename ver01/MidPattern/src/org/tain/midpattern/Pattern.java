package org.tain.midpattern;

import java.util.ArrayList;
import java.util.List;

public class Pattern {
	private String seq;
	private String pattern;   // eng
	private String meaning;   // kor
	private List<String> examples;
	public Pattern(String line) throws Exception {
		try {
			String[] parts = line.split("\\|");
			if (parts.length < 4)
				throw new Exception("wrong line - 1");

			this.seq = parts[0].trim();
			this.pattern = parts[1].trim();
			this.meaning = parts[2].trim();
			this.examples = new ArrayList<String>();
			for (int i=3; i < parts.length; i++) {
				this.examples.add(parts[i].trim());
			}
		} catch (Exception e) {
			// e.printStackTrace();
			throw new Exception("wrong line - 2");
		}
	}
	public Pattern(String seq, String pattern, String meaning, List<String> examples) {
		this.seq = seq;
		this.pattern = pattern;
		this.meaning = meaning;
		this.examples = examples;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public List<String> getExamples() {
		return examples;
	}
	public void setExamples(List<String> examples) {
		this.examples = examples;
	}
	public String toString() {
		return String.format("(%s) [%s:%s] -> %s"
				, this.getSeq()
				, this.getPattern()
				, this.getMeaning()
				, this.getExamples());
	}
}
