package com.nookandcove.controller;

//import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nookandcove.service.AdminRegistryInfoSavingService;

@Controller
public class AdminRegistryInfoSavingController {
	
	@Autowired
	private AdminRegistryInfoSavingService adminRegistryInfoSavingService;

	@RequestMapping(method = RequestMethod.GET, value = "/regConceptBoards")
	@ResponseBody
	public ModelAndView regConceptBoards(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegistryConceptBoardsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedRoomAndStyleRed")
	@ResponseBody
	public ModelAndView selectedRoomAndStyleRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedRoomAndStyleRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedStyleAndRoomRed")
	@ResponseBody
	public ModelAndView selectedStyleAndRoomRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedStyleAndRoomRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedStyleRoomAndPriceRed")
	@ResponseBody
	public ModelAndView selectedStyleRoomAndPriceRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedStyleRoomAndPriceRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/unCheckStyleAndPriceBoxesRed")
	@ResponseBody
	public ModelAndView unCheckStyleAndPriceBoxesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.unCheckStyleAndPriceBoxesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedRoomAndStyleImageUpload")
	@ResponseBody
	public ModelAndView selectedRoomAndStyleImageUpload(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedRoomAndStyleImageUploadInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectedRoomAndStyleImgUpRed")
	@ResponseBody
	public ModelAndView selectedRoomAndStyleImgUpRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedRoomAndStyleImageUpdateRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegAddNewBoards")
	@ResponseBody
	public ModelAndView adminRegAddNewBoards(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegConceptBoardsManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminConceptBoardsDataSaving")
	@ResponseBody
	public ModelAndView adminConceptBoardsDataSaving(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminConceptBoardsDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminRedConceptSpcBoardUpload")
	@ResponseBody
	public ModelAndView adminRedConceptSpcBoardUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminRegConceptBoardImageUploadInDB(imageUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminConceptBoardsDataModification")
	@ResponseBody
	public ModelAndView adminConceptBoardsDataModification(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminConceptBoardsDataModificationInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminRedConceptSpcBoardModificationUpload")
	@ResponseBody
	public ModelAndView adminRedConceptSpcBoardModificationUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminRedConceptSpcBoardModificationUploadInDB(imageUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegConceptBoardsManagementRedirect")
	@ResponseBody
	public ModelAndView adminRegConceptBoardsManagementRedirect(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegConceptBoardsManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminAddAnotherConceptBoards")
	@ResponseBody
	public ModelAndView adminAddAnotherConceptBoards(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminAddAnotherConceptBoardsDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminAddAnotherConceptSpcBoardUpload")
	@ResponseBody
	public ModelAndView adminAddAnotherConceptSpcBoardUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminAddAnotherConceptSpcBoardUploadInDB(imageUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRedConFurnitureSpectsUpload")
	@ResponseBody
	public ModelAndView adminRedConFurnitureSpectsUpload(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminConFurnitureSpectsUploadRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.POST, value = "/adminConFurnitureSpecsUploadDataSaving")
	@ResponseBody
	public ModelAndView adminConFurnitureSpecsUploadDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminConFurnitureSpecsUploadDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminConFurSpectsDataDisplayRed")
	@ResponseBody
	public ModelAndView adminConFurSpectsDataDisplayRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminConFurnitureSpectsDataDisplayFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminConFurnitureSpecsDisplayBack")
	@ResponseBody
	public ModelAndView adminConFurnitureSpecsDisplayBack(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegistryModifyRoomRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRedConFurnitureSpectsAddNewProducts")
	@ResponseBody
	public ModelAndView adminRedConFurnitureSpectsAddNewProducts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRedConFurnitureSpectsAddNewProductsRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRedConFurnitureSpectsEditProducts")
	@ResponseBody
	public ModelAndView adminRedConFurnitureSpectsEditProducts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRedConFurnitureSpectsEditProductsRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminConFurnitureSpecsModifiedDataSaving")
	@ResponseBody
	public ModelAndView adminConFurnitureSpecsModifiedDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminConFurnitureSpecsModifiedDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminConFurnitureSpecsDataDelete")
	@ResponseBody
	public ModelAndView adminConFurnitureSpecsDataDelete(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminConFurnitureSpecsDataDeleteFromDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegAddNewFinishingTouches")
	@ResponseBody
	public ModelAndView adminRegAddNewFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegistryFinishingTouchesUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/redirectAdminFinishingTouchesDisplay")
	@ResponseBody
	public ModelAndView redirectAdminFinishingTouchesDisplay(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegFinishingTouchesCategoriesManagement(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminRegFinishingTouchesManagementRedirect")
	@ResponseBody
	public ModelAndView adminRegFinishingTouchesManagementRedirect(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminRegFinishingTouchesManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminFinishingTouchesUploadDataSaving")
	@ResponseBody
	public ModelAndView adminFinishingTouchesUploadDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminFinishingTouchesUploadDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/adminFinishingTouchesAddNewProducts")
//	@ResponseBody
//	public ModelAndView adminFinishingTouchesAddNewProducts(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryInfoSavingService.adminFinishingTouchesAddNewProductsRedirection(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.GET, value = "/adminFinishingTouchesEditProducts")
//	@ResponseBody
//	public ModelAndView adminFinishingTouchesEditProducts(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryInfoSavingService.adminFinishingTouchesEditProductsRedirection(req, sn);
//	}

//	@RequestMapping(method = RequestMethod.GET, value = "/adminFinishingTouchesDataDelete")
//	@ResponseBody
//	public ModelAndView adminFinishingTouchesDataDelete(HttpServletRequest req, HttpSession sn) {
//		return adminRegistryInfoSavingService.adminFinishingTouchesDataDeleteFromDB(req, sn);
//	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminFinishingTouchesModifiedDataUpdate")
	@ResponseBody
	public ModelAndView adminFinishingTouchesModifiedDataUpdate(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminFinishingTouchesModifiedDataUpdateInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/selectedFinishingTouchesRed")
	@ResponseBody
	public ModelAndView selectedFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/selectedCBFinishingTouchesRed")
	@ResponseBody
	public ModelAndView selectedCBFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedCBFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/selectedFinishingTouchesImageEdit")
	@ResponseBody
	public ModelAndView selectedFinishingTouchesImageEdit(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.selectedFinishingTouchesImageEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/backToFinishingTouchesRed")
	@ResponseBody
	public ModelAndView backToFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.backToFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/unCheckFinishingTouchesCheckBoxes")
	@ResponseBody
	public ModelAndView unCheckFinishingTouchesCheckBoxes(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.backToFinishingTouchesRedirection(req, sn);
	}
	
	
//	Designer Side Registry Coding	
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerConceptBoards")
	@ResponseBody
	public ModelAndView adminDesignerConceptBoards(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRegistryConceptBoardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerSelectedRoomAndStyleRed")
	@ResponseBody
	public ModelAndView adminDesignerSelectedRoomAndStyleRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedRoomAndStyleRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerSelectedStyleAndRoomRed")
	@ResponseBody
	public ModelAndView adminDesignerSelectedStyleAndRoomRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedStyleAndRoomRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerSelectedStyleRoomAndPriceRed")
	@ResponseBody
	public ModelAndView adminDesignerSelectedStyleRoomAndPriceRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedStyleRoomAndPriceRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerUnCheckStyleAndPriceBoxesRed")
	@ResponseBody
	public ModelAndView adminDesignerUnCheckStyleAndPriceBoxesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerUnCheckStyleAndPriceBoxesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerSelectedRoomAndStyleImageUpload")
	@ResponseBody
	public ModelAndView adminDesignerSelectedRoomAndStyleImageUpload(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedRoomAndStyleImageUploadInDB(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerConcepts")
	@ResponseBody
	public ModelAndView adminDesignerConcepts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRegConceptBoardsManagement(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerConceptBoardsDataModification")
	@ResponseBody
	public ModelAndView adminDesignerConceptBoardsDataModification(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerConceptBoardsDataModificationInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerConFurnitureSpecsDataDelete")
	@ResponseBody
	public ModelAndView adminDesignerConFurnitureSpecsDataDelete(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerConFurnitureSpecsDataDeleteFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerConFurSpectsDataDisplayRed")
	@ResponseBody
	public ModelAndView adminDesignerConFurSpectsDataDisplayRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerConFurnitureSpectsDataDisplayFromDB(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRedConFurnitureSpectsEditProducts")
	@ResponseBody
	public ModelAndView adminDesignerRedConFurnitureSpectsEditProducts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRedConFurnitureSpectsEditProductsRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRedConFurnitureSpectsAddNewProducts")
	@ResponseBody
	public ModelAndView adminDesignerRedConFurnitureSpectsAddNewProducts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRedConFurnitureSpectsAddNewProductsRed(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerConFurnitureSpecsUploadDataSaving")
	@ResponseBody
	public ModelAndView adminDesignerConFurnitureSpecsUploadDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminDesignerConFurnitureSpecsUploadDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerConFurnitureSpecsDisplayBack")
	@ResponseBody
	public ModelAndView adminDesignerConFurnitureSpecsDisplayBack(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRegistryModifyRoomRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerConFurnitureSpecsModifiedDataSaving")
	@ResponseBody
	public ModelAndView adminDesignerConFurnitureSpecsModifiedDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminDesignerConFurnitureSpecsModifiedDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRedConFurnitureSpectsUpload")
	@ResponseBody
	public ModelAndView adminDesignerRedConFurnitureSpectsUpload(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerConFurnitureSpectsUploadRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerRedConceptSpcBoardModificationUpload")
	@ResponseBody
	public ModelAndView adminDesignerRedConceptSpcBoardModificationUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminDesignerRedConceptSpcBoardModificationUploadInDB(imageUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRedConFurnitureSpectsProdApproval")
	@ResponseBody
	public ModelAndView adminDesignerRedConFurnitureSpectsProdApproval(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRedConFurnitureSpectsProdApprovalInDB(req, sn);
	}
		
//Finishing Touches Coding

	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerSelectedFinishingTouchesRed")
	@ResponseBody
	public ModelAndView adminDesignerSelectedFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRegAddNewFinishingTouches")
	@ResponseBody
	public ModelAndView adminDesignerRegAddNewFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRegistryFinishingTouchesUploadRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/redirectAdminDesignerFinishingTouchesDisplay")
	@ResponseBody
	public ModelAndView redirectAdminDesignerFinishingTouchesDisplay(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.redirectAdminDesignerFinishingTouchesDisplayRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerSelectedCBFinishingTouchesRed")
	@ResponseBody
	public ModelAndView adminDesignerSelectedCBFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedCBFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerUnCheckFinishingTouchesCheckBoxes")
	@ResponseBody
	public ModelAndView adminDesignerUnCheckFinishingTouchesCheckBoxes(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.backToAdminDesignerFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerSelectedFinishingTouchesImageEdit")
	@ResponseBody
	public ModelAndView adminDesignerSelectedFinishingTouchesImageEdit(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerSelectedFinishingTouchesImageEditInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRegConceptBoardsManagementRedirect")
	@ResponseBody
	public ModelAndView adminDesignerRegConceptBoardsManagementRedirect(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRegConceptBoardsManagementRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/backToAdminDesignerFinishingTouchesRed")
	@ResponseBody
	public ModelAndView backToAdminDesignerFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.backToAdminDesignerFinishingTouchesRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerFinishingTouchesDataDelete")
	@ResponseBody
	public ModelAndView adminDesignerFinishingTouchesDataDelete(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerFinishingTouchesDataDeleteFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerFinishingTouchesEditProducts")
	@ResponseBody
	public ModelAndView adminDesignerFinishingTouchesEditProducts(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerFinishingTouchesEditProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/adminDesignerFinishingTouchesModifiedDataUpdate")
	@ResponseBody
	public ModelAndView adminDesignerFinishingTouchesModifiedDataUpdate(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return adminRegistryInfoSavingService.adminDesignerFinishingTouchesModifiedDataUpdateInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/adminDesignerRedFinishingTouchesSpectsProdApproval")
	@ResponseBody
	public ModelAndView adminDesignerRedFinishingTouchesSpectsProdApproval(HttpServletRequest req, HttpSession sn) {
		return adminRegistryInfoSavingService.adminDesignerRedFinishingTouchesSpectsProdApprovalInDB(req, sn);
	}
	
	

//	@RequestMapping(method = RequestMethod.GET, value = "/adminStockCheckPriceUpdate")
//	@ResponseBody
//	public ModelAndView adminStockCheckPriceUpdate(HttpServletRequest req, HttpSession sn) throws IOException {
//		return adminRegistryInfoSavingService.adminStockCheckPriceUpdateInDB(req, sn);
//	}
	
}
