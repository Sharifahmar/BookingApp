/**
 * 
 */
package com.acc.constant;

/**
 * @author ahmar.akhtar.sharif
 *This class is UrlConstant used to declare the final variable for controller class
 */
public class UrlConstant {

	public static final String GET_ALL_USERS = "/usercontroller/getAllUsers";
	public static final String GET_BY_PINCODE_ID = "/user/controller/getPincodeByPincode/{pin}";
	public static final String ADD_USER = "/user/controller/User";
	public static final String UPDATE_USER = "/user/controller/updateUser";
	public static final String DELETE_USER = "/user/controller/deleteUser/{id}";
	public static final String ADD_MEETING = "/user/controller/meeting";
	public static final String USER_LOGIN = "/user/controller/login";
	public static final String UPDATE_MEETING = "/user/controller/updateMeeting";
	public static final String CANCEL_MEETING = "/user/controller/cancelMeeting";
	public static final String GET_ALL_PRIORITY = "/priority/controller/getAllPriority";
	public static final String ADD_PRIORITY = "/priority/controller/addPriority";
	public static final String UPDATE_PRIORITY = "/priority/controller/updatePriority";
	public static final String DELETE_PRIORTIY = "/priority/controller/deletePriority/{id}";
	public static final String GET_PRIORITY_ID = "/priority/controller/getPriority/{id}";
}
