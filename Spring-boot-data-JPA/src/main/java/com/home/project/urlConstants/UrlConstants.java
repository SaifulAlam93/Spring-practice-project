package com.home.project.urlConstants;

public final class UrlConstants {
	private UrlConstants(){
		
	}
    
	private static final String API = "/api";
	private static final String VERSION = "/v1";

	public static class AssignedTaskController{
		public static final String ROOT = API + VERSION;
		public static final String GET_ALL = "/assignedTask";
		public static final String GET_ALL_ASSIGNED_TASKS = GET_ALL + "/getAll";
		public static final String GET_SCHEDULE_WISE_TASK = GET_ALL + "/getScheduleWiseTaskDetails";
	}

	public static class PlayersController{
		public static final String ROOT = API + VERSION;
		public static final String GET_ALL = "/players";
	}
	public static class TasksController{
		public static final String ROOT = API + VERSION;
		public static final String GET_ALL = "/tasks";
	}

	public static class ScheduleController{
		public static final String ROOT = API + VERSION;
		public static final String GET_ALL = "/schedule";
	}
}