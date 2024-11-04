package com.nookandcove.controller;

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

import com.nookandcove.service.DesignerRegistryInfoSavingService;

@Controller
public class DesignerRegistryInfoSavingController {
	
	@Autowired
	private DesignerRegistryInfoSavingService designerRegistryInfoSavingService;

	@RequestMapping(method = RequestMethod.GET, value = "/designerRegConceptBoards")
	@ResponseBody
	public ModelAndView regConceptBoards(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegistryConceptBoardsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRegAddNewBoards")
	@ResponseBody
	public ModelAndView designerRegAddNewBoards(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegConceptBoardsManagement(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerConceptBoardsDataSaving")
	@ResponseBody
	public ModelAndView designerConceptBoardsDataSaving(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegConceptBoardsDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerRedConceptSpcBoardUpload")
	@ResponseBody
	public ModelAndView designerRedConceptSpcBoardUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerRedConceptSpcBoardImageUploadInDB(imageUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRedConFurnitureSpectsUpload")
	@ResponseBody
	public ModelAndView designerRedConFurnitureSpectsUpload(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerConFurnitureSpectsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerConFurnitureSpecsUploadDataSaving")
	@ResponseBody
	public ModelAndView designerConFurnitureSpecsUploadDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerConFurnitureSpecsUploadDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerConFurSpectsDataDisplayRed")
	@ResponseBody
	public ModelAndView designerConFurSpectsDataDisplayRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerConFurnitureSpectsDataDisplayFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRegConceptBoardsManagementRedirect")
	@ResponseBody
	public ModelAndView designerRegConceptBoardsManagementRedirect(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegConceptBoardsManagementRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerRedConceptSpcBoardModificationUpload")
	@ResponseBody
	public ModelAndView designerRedConceptSpcBoardModificationUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerRedConceptSpcBoardModificationUploadInDB(imageUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerAddAnotherConceptSpcBoardUpload")
	@ResponseBody
	public ModelAndView designerAddAnotherConceptSpcBoardUpload(@RequestParam("regPhotoUpload") MultipartFile imageUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerAddAnotherConceptSpcBoardUploadInDB(imageUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerConceptBoardsDataModification")
	@ResponseBody
	public ModelAndView designerConceptBoardsDataModification(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerConceptBoardsDataModificationInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerAddAnotherConceptBoards")
	@ResponseBody
	public ModelAndView designerAddAnotherConceptBoards(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerAddAnotherConceptBoardsDataSavingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerConFurnitureSpecsDataDelete")
	@ResponseBody
	public ModelAndView designerConFurnitureSpecsDataDelete(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerConFurnitureSpecsDataDeleteFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRedConFurnitureSpectsEditProducts")
	@ResponseBody
	public ModelAndView designerRedConFurnitureSpectsEditProducts(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRedConFurnitureSpectsEditProductsRed(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerConFurnitureSpecsModifiedDataSaving")
	@ResponseBody
	public ModelAndView designerConFurnitureSpecsModifiedDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerConFurnitureSpecsModifiedDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRedConFurnitureSpectsAddNewProducts")
	@ResponseBody
	public ModelAndView designerRedConFurnitureSpectsAddNewProducts(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRedConFurnitureSpectsAddNewProductsRed(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerConFurnitureSpecsDisplayBack")
	@ResponseBody
	public ModelAndView designerConFurnitureSpecsDisplayBack(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegistryModifyRoomRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerSelectedRoomAndStyleImageUpload")
	@ResponseBody
	public ModelAndView designerSelectedRoomAndStyleImageUpload(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedRoomAndStyleImageUploadInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerSelectedRoomAndStyleRed")
	@ResponseBody
	public ModelAndView designerSelectedRoomAndStyleRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedRoomAndStyleRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerSelectedStyleAndRoomRed")
	@ResponseBody
	public ModelAndView designerSelectedStyleAndRoomRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedStyleAndRoomRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerSelectedStyleRoomAndPriceRed")
	@ResponseBody
	public ModelAndView designerSelectedStyleRoomAndPriceRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedStyleRoomAndPriceRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerUnCheckStyleAndPriceBoxesRed")
	@ResponseBody
	public ModelAndView designerUnCheckStyleAndPriceBoxesRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerUnCheckStyleAndPriceBoxesRedirection(req, sn);
	}	
	
	
//	Finishing Touches Coding

	@RequestMapping(method = RequestMethod.POST, value = "/designerSelectedFinishingTouchesRed")
	@ResponseBody
	public ModelAndView designerSelectedFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerRegAddNewFinishingTouches")
	@ResponseBody
	public ModelAndView designerRegAddNewFinishingTouches(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerRegistryFinishingTouchesUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerFinishingTouchesUploadDataSaving")
	@ResponseBody
	public ModelAndView designerFinishingTouchesUploadDataSaving(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerFinishingTouchesUploadDataSavingInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/redirectDesignerFinishingTouchesDisplay")
	@ResponseBody
	public ModelAndView redirectDesignerFinishingTouchesDisplay(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.redirectDesignerFinishingTouchesDisplayRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/backToDsnFinishingTouchesRed")
	@ResponseBody
	public ModelAndView backToDsnFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.backToDsnFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerFinishingTouchesDataDelete")
	@ResponseBody
	public ModelAndView designerFinishingTouchesDataDelete(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerFinishingTouchesDataDeleteFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerFinishingTouchesEditProducts")
	@ResponseBody
	public ModelAndView designerFinishingTouchesEditProducts(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerFinishingTouchesEditProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerFinishingTouchesAddNewProducts")
	@ResponseBody
	public ModelAndView designerFinishingTouchesAddNewProducts(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerFinishingTouchesAddNewProductsRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerFinishingTouchesModifiedDataUpdate")
	@ResponseBody
	public ModelAndView designerFinishingTouchesModifiedDataUpdate(@RequestParam("productUploadedImage1") MultipartFile productUploadedImage1, @RequestParam("productUploadedImage2") MultipartFile productUploadedImage2, @RequestParam("productUploadedImage3") MultipartFile productUploadedImage3, @RequestParam("productUploadedImage4") MultipartFile productUploadedImage4, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerRegistryInfoSavingService.designerFinishingTouchesModifiedDataUpdateInDB(productUploadedImage1, productUploadedImage2, productUploadedImage3, productUploadedImage4, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerSelectedCBFinishingTouchesRed")
	@ResponseBody
	public ModelAndView designerSelectedCBFinishingTouchesRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedCBFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerUnCheckFinishingTouchesCheckBoxes")
	@ResponseBody
	public ModelAndView designerUnCheckFinishingTouchesCheckBoxes(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.backToDsnFinishingTouchesRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/designerSelectedFinishingTouchesImageEdit")
	@ResponseBody
	public ModelAndView designerSelectedFinishingTouchesImageEdit(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedFinishingTouchesImageEditInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerSelectedRoomAndStyleImgUpRed")
	@ResponseBody
	public ModelAndView designerSelectedRoomAndStyleImgUpRed(HttpServletRequest req, HttpSession sn) {
		return designerRegistryInfoSavingService.designerSelectedRoomAndStyleImageUpdateRedirection(req, sn);
	}

	
	
}
