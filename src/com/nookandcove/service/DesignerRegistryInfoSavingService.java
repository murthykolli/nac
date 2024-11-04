package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface DesignerRegistryInfoSavingService {
	
	public ModelAndView designerRegistryConceptBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegConceptBoardsManagement(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegConceptBoardsManagementDataDisplay(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegAddNewBoardsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRedConceptSpcBoardImageUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerConFurnitureSpectsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerConFurnitureSpecsUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerConFurnitureSpectsDataDisplayFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegConceptBoardsManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegistryModifyRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegistryDeleteRoomRedirection(HttpServletRequest req, HttpSession sn, long conceptBoardsSavingId);
	public ModelAndView designerRegistryAddNewRoomRedirect(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRedConceptSpcBoardModificationUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerAddAnotherConceptSpcBoardUploadInDB(MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerConceptBoardsDataModificationInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerAddAnotherConceptBoardsDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerConFurnitureSpecsDataDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRedConFurnitureSpectsEditProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerConFurnitureSpecsModifiedDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerConFurnitureSpecsEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminConFSProductsId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView designerRedConFurnitureSpectsAddNewProductsRed(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSelectedRoomAndStyleImageUploadInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSelectedRoomAndStyleRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSelectedStyleAndRoomRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSelectedRoomStyleAndPriceCombDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames, String priceValue);
	public ModelAndView designerSelectedRoomAndStyleDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String styleNames);
	public ModelAndView designerSelectedRoomAndPriceDataTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName, String price);
	public ModelAndView designerSelectedRoomDataOnlyTakeFromDB(HttpServletRequest req, HttpSession sn, String rommName);
	public ModelAndView designerSelectedStyleRoomAndPriceRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerUnCheckStyleAndPriceBoxesRedirection(HttpServletRequest req, HttpSession sn);
	
//	Finishing Touches Coding
	public ModelAndView designerSelectedFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegistryFinishingTouchesUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerFinishingTouchesUploadDataSavingInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView redirectDesignerFinishingTouchesDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView backToDsnFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerFinishingTouchesDataDeleteFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerFinishingTouchesEditProductsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerFinishingTouchesAddNewProductsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerFinishingTouchesModifiedDataUpdateInDB(MultipartFile productUploadedImage1, MultipartFile productUploadedImage2, MultipartFile productUploadedImage3, MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerFinishingTouchesImagesEditdDataUpdateInDB(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId, byte[] bFile1, byte[] bFile2, byte[] bFile3, byte[] bFile4, String editFileName1, String editFileName2, String editFileName3, String editFileName4);
	public ModelAndView designerSelectedCBFinishingTouchesRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerRegSelectedCheckBoxFinishingTouchesList(HttpServletRequest req, HttpSession sn, String prodCategory);
	public ModelAndView designerSelectedFinishingTouchesImageEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSelectedFinishingTouchesImageEditRedirection(HttpServletRequest req, HttpSession sn, long adminRegFinishingTouchesSavingId);
	public ModelAndView designerSelectedRoomAndStyleImageUpdateRedirection(HttpServletRequest req, HttpSession sn);
	
	
	public Timestamp currentDate();
	
}
