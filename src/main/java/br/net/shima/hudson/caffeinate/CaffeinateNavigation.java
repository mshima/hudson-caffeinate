package br.net.shima.hudson.caffeinate;

import br.net.shima.utils.caffeinate.CaffeinateThread;
import hudson.Extension;
import hudson.model.PageDecorator;

@Extension
public class CaffeinateNavigation extends PageDecorator {

	private CaffeinateThread caffeinate = new CaffeinateThread();

	public CaffeinateNavigation() {
		super(CaffeinateNavigation.class);
	}

	public String caffeinate() {
		caffeinate.smallCaffeinate();
		System.out.println("Caffeinate");
		return "Caffeinate";
	}

}
