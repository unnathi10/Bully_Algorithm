package com.bully;


public class ProcessElection {


	private static boolean isElection = false;
	private static boolean isPingLeader = true;
	public static Process electionInitiator;

	public static Process getElectionInitiator() {
		return electionInitiator;
	}

	public static void setElectionInitiator(Process electionInitiator) {
		ProcessElection.electionInitiator = electionInitiator;
	}

	public static boolean isPingLeaderFlag() {
		return isPingLeader;
	}

	public static void setPingLeaderFlag(boolean pingLeaderFlag) {
		ProcessElection.isPingLeader = pingLeaderFlag;
	}

	public static boolean isElectionFlag() {
		return isElection;
	}

	public static void setElectionFlag(boolean electionFlag) {
		ProcessElection.isElection = electionFlag;
	}
	
	
}
