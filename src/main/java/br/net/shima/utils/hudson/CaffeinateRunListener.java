package br.net.shima.utils.hudson;

import hudson.Extension;
import hudson.model.TaskListener;
import hudson.model.AbstractBuild;
import hudson.model.listeners.RunListener;
import br.net.shima.utils.caffeinate.CaffeinateThread;

@Extension
public class CaffeinateRunListener extends RunListener<AbstractBuild<?, ?>> {

	private CaffeinateThread caffeinate = new CaffeinateThread();

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
