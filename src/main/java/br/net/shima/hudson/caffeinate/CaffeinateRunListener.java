package br.net.shima.hudson.caffeinate;

import hudson.Extension;
import hudson.model.TaskListener;
import hudson.model.AbstractBuild;
import hudson.model.listeners.RunListener;
import br.net.shima.utils.caffeinate.CaffeinateRunner;

@Extension
public class CaffeinateRunListener extends RunListener<AbstractBuild<?, ?>> {

	private CaffeinateRunner caffeinate = new CaffeinateRunner();

	public CaffeinateRunListener() {
	}

	@Override
	public void onStarted(AbstractBuild<?, ?> r, TaskListener listener) {
		listener.getLogger().println("Starting caffeined for name " + r.getId());
		this.caffeinate.cancelableCaffeinate(r.getId());
		super.onStarted(r, listener);
	}

	@Override
	public void onCompleted(AbstractBuild<?, ?> r, TaskListener listener) {
		listener.getLogger().println("Canceling caffeined for name " + r.getId());
		this.caffeinate.cancel(r.getId());
		this.caffeinate.tinyCaffeinate();
		super.onCompleted(r, listener);
	}

}
