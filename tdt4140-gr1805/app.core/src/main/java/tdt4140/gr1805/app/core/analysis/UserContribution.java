package tdt4140.gr1805.app.core.analysis;

public class UserContribution {

	private boolean contribution=true;

	public UserContribution(boolean contribution){
		this.contribution=contribution;
	}

	public void setContribution(boolean contributionInput) {
		contribution=contributionInput;
	}

	public boolean getContribution() {
		return contribution;
	}
}