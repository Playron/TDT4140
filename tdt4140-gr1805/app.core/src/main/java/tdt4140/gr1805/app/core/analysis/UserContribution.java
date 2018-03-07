package tdt4140.gr1805.app.core.analysis;

public class UserContribution {

	private boolean contribution;

	public UserContribution(){
		this.contribution=true;
	}

	public void setContribution(boolean contributionInput) {
		contribution=contributionInput;
	}

	public boolean getContribution() {
		return contribution;
	}
}