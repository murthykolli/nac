package com.nookandcove.service;

//import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface AdminRegistryInfoSavingService {
	
	public ModelAndView adminRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price);
	public ModelAndView selectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue);
	public ModelAndView unCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName);
	public ModelAndView selectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames);
	public ModelAndView selectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedRoomAndStyleImageUpdateRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegAddNewBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegConceptBoardImageUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAddAnotherConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAddAnotherConceptSpcBoardUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminRegistryAddNewRoomRedirect(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId);
	public ModelAndView adminConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView adminConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminFinishingTouchesUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminRegFinishingTouchesCategoriesManagement(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegFinishingTouchesCategoriesManagementDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminRegFinishingTouchesManagementRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView redirectAdminFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn);
//	public ModelAndView adminFinishingTouchesAddNewProductsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId);
	public ModelAndView adminFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView adminFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId);
	public ModelAndView selectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView regiSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory);
	public ModelAndView selectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView selectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId);
	public ModelAndView backToFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	
	
	
//	Designer Side Registry Coding
	
	public ModelAndView adminDesignerRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue);
	public ModelAndView adminDesignerSelectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames);
	public ModelAndView adminDesignerSelectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price);
	public ModelAndView adminDesignerSelectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName);
	public ModelAndView adminDesignerSelectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerUnCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId);
	public ModelAndView adminDesignerRegistryApprovedStatusRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId);
	public ModelAndView adminDesignerConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminDesignerConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminDesignerConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView adminDesignerConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminDesignerRedConFurnitureSpectsProdApprovalInDB(HttpServletRequest req, HttpSession sn);
	
	
//	Finishing Touches Coding
	
	public ModelAndView adminDesignerSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView redirectAdminDesignerFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerRegSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory);
	public ModelAndView backToAdminDesignerFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerSelectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId);
	public ModelAndView adminDesignerFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminDesignerFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView adminDesignerFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView adminDesignerRedFinishingTouchesSpectsProdApprovalInDB(HttpServletRequest req, HttpSession sn);
	
	
//	public ModelAndView adminStockCheckPriceUpdateInDB(HttpServletRequest req, HttpSession sn) throws IOException;
	
	public Timestamp currentDate();
	
}
