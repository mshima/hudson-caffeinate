package br.net.shima.hudson.caffeinate;

import hudson.Extension;
import hudson.model.PageDecorator;
import br.net.shima.utils.caffeinate.CaffeinateRunner;

@Extension
public class CaffeinateNavigation extends PageDecorator {

	private CaffeinateRunner caffeinate = new CaffeinateRunner();

	public CaffeinateNavigation() {
		super(CaffeinateNavigation.class);
	}

	public String caffeinate() {
		boolean smallCaffeinate = caffeinate.smallCaffeinate();
		if(smallCaffeinate){
			return "Caffeinate";
		}
		return "Caffeinate failed";
	}

}
