package com.bully;

public class Process {

	int pid;
	boolean isProcessCoordinator, isProcessDown;
	
	public Process() {
		
	}

	public Process(int pid) {
		this.pid = pid;
		this.isProcessDown = false;
		this.isProcessCoordinator = false;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
		
	public boolean isCoordinatorFlag() {
		return isProcessCoordinator;
	}

	public void setCoordinatorFlag(boolean isProcessCoordinator) {
		this.isProcessCoordinator = isProcessCoordinator;
	}
	
	public boolean isDownflag() {
		return isProcessDown;
	}

	public void setDownflag(boolean downflag) {
		this.isProcessDown = downflag;
	}

}
