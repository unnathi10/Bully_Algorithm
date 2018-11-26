package com.bully;

import java.util.*;

public class ModifiedBullyAlgorithm {
	
	public static Process leader;

	//Main function
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter the number of processes: ");
		Scanner in = new Scanner(System.in);
		int no_of_processes = in.nextInt();
		
		//store the processes in a list
		ArrayList<Process> pl = new ArrayList<Process>();
		
		for (int i = 0; i < no_of_processes; i++)
			pl.add(new Process(i));
		
		//initially select a leader
		leader = initialElection(pl, no_of_processes);
		System.out.println("Coordinator is : P"+ leader.getPid());
		
		//processes communicate with the leader. If leader is down, then election process is executed.
		pingLeader(pl, leader);
		while(ProcessElection.isElectionFlag()) {
			election(pl,leader);
		}
		ProcessElection.setPingLeaderFlag(true);
		
	}
	
	//initially select a leader
	public static Process initialElection(ArrayList<Process> pl, int no_of_processes) {
		Process temp = new Process(-1);
		for (int i = 0; i < pl.size(); i++) {
			Process p = (Process) pl.get(i);
			if (temp.getPid() < p.getPid())
				temp = p;
		}
		temp.setCoordinatorFlag(true);
		return temp;	
	}
	

	//ping leader to check if its active
	public static void pingLeader(ArrayList<Process> pl, Process leader) {
		Random random = new Random();
		int r = random.nextInt(15);
		int j = 0;
		while(ProcessElection.isPingLeaderFlag()) {
		for(int i = 0; i<pl.size(); i++) {
			Process p = (Process) pl.get(i);
			if(!(p.isCoordinatorFlag())) {
				System.out.println("P" + p.getPid() + ": Coordinator, are you there?");
				j++;
				if(j==r)
					leader.setDownflag(true);
				if(!(leader.isDownflag()))
					System.out.println("P" +leader.getPid() + ": Yes");
				else {
					ProcessElection.setElectionFlag(true);
					ProcessElection.setElectionInitiator(p);
					System.out.println("P" + p.getPid() + ": Coordinator is down. Initiating election..");
					ProcessElection.setPingLeaderFlag(false);
					break;
				}
			}
		  }
		}
	}
	
	//Elect a new leader
	public static void election(ArrayList<Process> pl, Process leader) {
		Process ed = ProcessElection.getElectionInitiator();
		int max = ed.getPid();
		System.out.print("\n");
		for(int i = ed.getPid()+1; i<pl.size();i++) {
			System.out.println("P" + ed.getPid() + ": Sending message to P" + i);
			Process a = pl.get(i);
			if(!(a.isDownflag())) {
				System.out.println("P" + a.getPid() + ": Im Here! My ID is " + a.getPid());
				if(max < a.getPid()) {
					max = a.getPid();
				}
			}
			else {
				System.out.println("P" + ed.getPid() + ": No response from P" + i);
			}
		}
		leader = pl.get(max);
		ProcessElection.setElectionFlag(false);
		leader.setCoordinatorFlag(true);
		System.out.println("\nNew Coordinator is : P" + leader.getPid());
		
	    
	}
	
}


