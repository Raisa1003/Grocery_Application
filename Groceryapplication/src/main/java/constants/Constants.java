package constants;

public class Constants {

	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String lp_verifyLoginWithValidCredentials="login failed for valid credentials";
	public static final String lp_verifyLoginWithInvalidCrendials="Alert message is not as expected";
	public static final String TEST_DATA_FILE=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
	public static final String TEST_DATA_IMAGE= System.getProperty("user.dir") +"\\src\\test\\resources\\Images\\bunny1.jpeg";
	public static final String TEST_DATA_IMAGE_KIWI= System.getProperty("user.dir") +"\\src\\test\\resources\\Images\\kiwi.jpeg";
	public static final String TEST_DATA_IMAGE_POMEGRANATE= System.getProperty("user.dir") +"\\src\\test\\resources\\Images\\pomegranate.jpeg";
	
	
	public static final String AU_verifyUserCanAddNewAdminDetails="Admin User is not created successfully";
	public static final String AU_verifyUserCanChangeStatusOfAdminDetails="Admin status is not displayed successfully";
	public static final String AU_verifyUserCanSearchAdminUserInfo="Admin user details not found successfully";
	
	public static final String CA_validateUserCanChangeActiveCategoryStatus=" Category status is not changed successfully";
	public static final String CA_verifyUserCanAddNewCategory="Category is not created successfully";
	public static final String CA_verifyCategoryIsDeleted="Category is not deleted successfully";
	
	public static final String MC_verifyUserCanUpdateContactDetails= "Contacts are not updated successfully";
	
	public static final String MF_verifyUserCanUpdateAdminFooterDetails= "Footer Text is not updated successfully";
	
	public static final String MN_verifyAdminUserCanAddNews= "News is not added successfully";
	public static final String MN_verifyAdminUserCanManageAndEditNews= "News is not updated successfully";
	
	public static final String SC_verifyAddNewSubcategorywithValidDetails="Subcategory is not added successfully";
	public static final String SC_verifySubCategoryIsDeleted="Subcategory is not deleted successfully";
	public static final String SC_verifySearchSubCategory="Subcategory is not found successfully";

	
	
	
	
}
