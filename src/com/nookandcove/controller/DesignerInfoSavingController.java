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

import com.nookandcove.service.DesignerInfoSavingService;

@Controller
public class DesignerInfoSavingController {
	
	@Autowired
	private DesignerInfoSavingService designerInfoSavingService;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerClients")
	@ResponseBody
	public ModelAndView designerClients(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerClientsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desnArchiveClientsInfo")
	@ResponseBody
	public ModelAndView desnArchiveClientsInfo(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerClientsArchiveRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designerClArchiveDataUpdate")
	@ResponseBody
	public ModelAndView designerClArchiveDataUpdate(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerClArchiveDataUpdateInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/newClientRequestToAdmin")
	@ResponseBody
	public ModelAndView newClientRequestToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.newClientRequestToAdminRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/newClientRequestCancelFromAdmin")
	@ResponseBody
	public ModelAndView newClientRequestCancelFromAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.newClientRequestCancelFromAdminRedirection(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/accStyleManagement")
	@ResponseBody
	public ModelAndView accStyleManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSideAccessoriesPackageRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accBudgetManagement")
	@ResponseBody
	public ModelAndView accBudgetManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accBudgetManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accDimensionsManagement")
	@ResponseBody
	public ModelAndView accDimensionsManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accDimensionsManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accColorManagement")
	@ResponseBody
	public ModelAndView accColorManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accColorManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accFurnitureManagement")
	@ResponseBody
	public ModelAndView accFurnitureManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accFurnitureManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accArtManagement")
	@ResponseBody
	public ModelAndView accArtManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accArtManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accMyRoomManagement")
	@ResponseBody
	public ModelAndView accMyRoomManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accMyRoomManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/accInspirationManagement")
	@ResponseBody
	public ModelAndView accInspirationManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.accInspirationManagementRedirection(req, sn);
	}	
		
	@RequestMapping(method = RequestMethod.GET, value = "/fullStyleManagement")
	@ResponseBody
	public ModelAndView fullStyleManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSideFullRoomDesignPackageRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullBudgetManagement")
	@ResponseBody
	public ModelAndView fullBudgetManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullBudgetManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullDimensionsManagement")
	@ResponseBody
	public ModelAndView fullDimensionsManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullDimensionsManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullColorManagement")
	@ResponseBody
	public ModelAndView fullColorManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullColorManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullFurnitureManagement")
	@ResponseBody
	public ModelAndView fullFurnitureManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullFurnitureManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullArtManagement")
	@ResponseBody
	public ModelAndView fullArtManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullArtManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullMyRoomManagement")
	@ResponseBody
	public ModelAndView fullMyRoomManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullMyRoomManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullInspirationManagement")
	@ResponseBody
	public ModelAndView fullInspirationManagement(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullInspirationManagementRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadAccPackConceptsAndRenderings")
	@ResponseBody
	public ModelAndView desnUploadAccPackConceptsAndRenderings(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accUploadConcept1Images")
	@ResponseBody
	public ModelAndView accUploadConcept1Images(@RequestParam("concept1Upload") MultipartFile concept1Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.accDesignerUploadConcept1ImageInDB(concept1Upload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/accUploadConcept2Images")
	@ResponseBody
	public ModelAndView accUploadConcept2Images(@RequestParam("concept2Upload") MultipartFile concept2Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.accDesignerUploadConcept2ImageInDB(concept2Upload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/accUploadFinalConceptImages")
	@ResponseBody
	public ModelAndView accUploadFinalConceptImages(@RequestParam("thDRendeingUpload") MultipartFile thDRendeingUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.accDesignerUploadFinalConceptImageInDB(thDRendeingUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirimageUploadInDB")
	@ResponseBody
	public ModelAndView reDirimageUploadInDB(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.desnUploadAccPackConceptsAndRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitAccPackConceptsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitAccPackConceptsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitAccPackConceptsToAdminRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitAccPackFinalConceptsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitAccPackFinalConceptsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitAccPackFinalConceptsToAdminRedirection(req, sn);
	}	 

	@RequestMapping(method = RequestMethod.GET, value = "/desnUploadFullRoomConceptsAndRenderings")
	@ResponseBody
	public ModelAndView desnUploadFullRoomConceptsAndRenderings(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadConcept1Images")
	@ResponseBody
	public ModelAndView fullRoomUploadConcept1Images(@RequestParam("concept1Upload") MultipartFile concept1Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadConcept1ImagesInDB(concept1Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadConcept2Images")
	@ResponseBody
	public ModelAndView fullRoomUploadConcept2Images(@RequestParam("concept2Upload") MultipartFile concept2Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadConcept2ImagesInDB(concept2Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadSecRendConcept1Images")
	@ResponseBody
	public ModelAndView fullRoomUploadSecRendConcept1Images(@RequestParam("secRendeing1Upload") MultipartFile secRendeing1Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadSecRendConcept1ImagesInDB(secRendeing1Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadSecRendConcept2Images")
	@ResponseBody
	public ModelAndView fullRoomUploadSecRendConcept2Images(@RequestParam("secRendeing2Upload") MultipartFile secRendeing2Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadSecRendConcept2ImagesInDB(secRendeing2Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadRendering1Images")
	@ResponseBody
	public ModelAndView fullRoomUploadRendering1Images(@RequestParam("rendeing1Upload") MultipartFile rendeing1Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadRendering1ImagesInDB(rendeing1Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadRendering2Images")
	@ResponseBody
	public ModelAndView fullRoomUploadRendering2Images(@RequestParam("rendeing2Upload") MultipartFile rendeing2Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadRendering2ImagesInDB(rendeing2Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadRevRendering1Images")
	@ResponseBody
	public ModelAndView fullRoomUploadRevRendering1Images(@RequestParam("revRendeing1Upload") MultipartFile revRendeing1Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadRevRendering1ImagesInDB(revRendeing1Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomUploadRevRendering2Images")
	@ResponseBody
	public ModelAndView fullRoomUploadRevRendering2Images(@RequestParam("revRendeing2Upload") MultipartFile revRendeing2Upload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.fullRoomUploadRevRendering2ImagesInDB(revRendeing2Upload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirFullRoomImageUploadInDB")
	@ResponseBody
	public ModelAndView reDirFullRoomImageUploadInDB(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.desnUploadFullRoomConceptsAndRenderingsRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitFullRoomConceptsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitFullRoomConceptsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitFullRoomConceptsToAdminRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitFullRoomRenderingsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitFullRoomRenderingsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitFullRoomRenderingsToAdminRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitFullRoomRevisedRenderingsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitFullRoomRevisedRenderingsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitFullRoomRevisedRenderingsToAdminRedirection(req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/designerSubmitFullRoom2ndRenderingsToAdmin")
	@ResponseBody
	public ModelAndView designerSubmitFullRoom2ndRenderingsToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerSubmitFullRoom2ndRenderingsToAdminRedirection(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/designerAccount")
	@ResponseBody
	public ModelAndView designerAccount(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerAccountRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uploadDesignerProfile")
	@ResponseBody
	public ModelAndView uploadDesignerProfile(@RequestParam("fileDesnUpload") MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.uploadDesignerProfileInDBTables(fileDesnUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirDesignerImageInDB")
	@ResponseBody
	public ModelAndView reDirDesignerImageInDB(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reLoadDesignerUploadImagesInDBTables(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/messageAdmin")
	@ResponseBody
	public ModelAndView messageAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.messageForAdminRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewClientMessageInfo")
	@ResponseBody
	public ModelAndView viewClientMessageInfo(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.viewClientMessageRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/adminMessageClient")
	@ResponseBody
	public ModelAndView adminMessageClient(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerMessageForClientRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/designerNotesDisplay")
	@ResponseBody
	public ModelAndView designerNotesDisplay(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerNotesDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerNotesDataSaving")
	@ResponseBody
	public ModelAndView designerNotesDataSaving(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerNotesDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fullRoomDesignerNotesDisplay")
	@ResponseBody
	public ModelAndView fullRoomDesignerNotesDisplay(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullRoomDesignerNotesDisplayRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/fullRoomDesignerNotesDataSaving")
	@ResponseBody
	public ModelAndView fullRoomDesignerNotesDataSaving(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.fullRoomDesignerNotesDataSavingInDB(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/designerUpdateAccPackCheckList")
	@ResponseBody
	public ModelAndView designerUpdateAccPackCheckList(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerUpdateAccPackCheckListInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerUpdateFullPackCheckList")
	@ResponseBody
	public ModelAndView designerUpdateFullPackCheckList(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerUpdateFullPackCheckListInDB(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/designerMessageSendToClient")
	@ResponseBody
	public ModelAndView designerMessageSendToClient(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerMessageSendToClientRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirDesignerAndClientMes")
	@ResponseBody
	public ModelAndView reDirDesignerAndClientMes(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerAndClientMessageInfoRedirection(req, sn);
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/designerMessageSendToAdmin")
	@ResponseBody
	public ModelAndView designerMessageSendToAdmin(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerMessageSendToAdminRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reDirDesignerAndAdminMes")
	@ResponseBody
	public ModelAndView reDirDesignerAndAdminMes(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.adminAndDesignerMessageInfoRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsAccPackConcepts1ProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsAccPackConcepts1ProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsAccPackDisplayBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsAccPackDisplayBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsAccPackDisplayBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts1AccPackProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1AccPackProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsCon1AccPackAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsCon1AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsCon1AccPackAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsCon1AccPack")
	@ResponseBody
	public ModelAndView reDirfurnSpecsCon1AccPack(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsCon1AccPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1AccPackAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1AccPackAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1AccPackDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1AccPackDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1AccPackEdit")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1AccPackEdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts1AccPackEditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1AccPackEditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts1AccPackEditedProdSavingInDB(fileUpload, req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsAccPackConcepts2ProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsAccPackConcepts2ProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts2AccPackProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2AccPackProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsCon2AccPackAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsCon2AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsCon2AccPackAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsCon2AccPack")
	@ResponseBody
	public ModelAndView reDirfurnSpecsCon2AccPack(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsCon2AccPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2AccPackAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2AccPackAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2AccPackDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2AccPackDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2AccPackEdit")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2AccPackEdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts2AccPackEditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2AccPackEditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts2AccPackEditedProdSavingInDB(fileUpload, req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsAccPackFinalConceptProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsAccPackFinalConceptProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFinalConceptProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsFinalConceptAccPackProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFinalConceptAccPackAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsAccPackFinalConcept")
	@ResponseBody
	public ModelAndView reDirfurnSpecsAccPackFinalConcept(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFinalConceptAccPackAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFinalConceptAccPackDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFinalConceptAccPackEdit")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackEdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackEditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsFinalConceptAccPackEditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsFinalConceptAccPackEditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsFinalConceptAccPackEditedProdSavingInDB(fileUpload, req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFullRmConcepts1ProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsFullRmConcepts1ProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1ProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFRDisplayBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsFRDisplayBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsFRDisplayBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts1FRProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1FRProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts1FRProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsCon1FRAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsCon1FRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsCon1FRAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsCon1FullRmPack")
	@ResponseBody
	public ModelAndView reDirfurnSpecsCon1FullRmPack(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsCon1FullRmPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1FRAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1FRAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1FRAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1FRDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1FRDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1FRDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts1FREdit")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1FREdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts1FREditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts1FREditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts1FREditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts1FREditedProdSavingInDB(fileUpload, req, sn);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFullRmConcepts2ProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsFullRmConcepts2ProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2ProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts2FRProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2FRProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts2FRProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsCon2FRAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsCon2FRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsCon2FRAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsCon2FullRmPack")
	@ResponseBody
	public ModelAndView reDirfurnSpecsCon2FullRmPack(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsCon2FullRmPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2FRAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2FRAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2FRAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2FRDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2FRDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2FRDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsConcepts2FREdit")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2FREdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsConcepts2FREditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsConcepts2FREditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsConcepts2FREditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsConcepts2FREditedProdSavingInDB(fileUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFullRmRoomRenderingProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsFullRmRoomRenderingProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRoomRenderingProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsRoomRenderingFRProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFRProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFRProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRoomRenderingFRAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFRAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsFullRmPackRoomRendering")
	@ResponseBody
	public ModelAndView reDirfurnSpecsFullRmPackRoomRendering(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRoomRenderingFRAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFRAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFRAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRoomRenderingFRDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFRDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFRDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRoomRenderingFREdit")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFREdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFREditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsRoomRenderingFREditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsRoomRenderingFREditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsRoomRenderingFREditedProdSavingInDB(fileUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFullRm2ndRenderingProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsFullRm2ndRenderingProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecs2ndRenderingProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecs2ndRenderingFRProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFRProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFRProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecs2ndRenderingFRAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFRAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsFullRmPack2ndRendering")
	@ResponseBody
	public ModelAndView reDirfurnSpecsFullRmPack2ndRendering(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecs2ndRenderingFRAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFRAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFRAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecs2ndRenderingFRDelete")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFRDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFRDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecs2ndRenderingFREdit")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFREdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFREditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecs2ndRenderingFREditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecs2ndRenderingFREditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecs2ndRenderingFREditedProdSavingInDB(fileUpload, req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsFullRmRevisedRenderingProdUp")
	@ResponseBody
	public ModelAndView furnitureSpecsFullRmRevisedRenderingProdUp(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingProductsUploadRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsRevisedRenderingFRProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFRProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFRProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRevisedRenderingFRAddNewBackMove")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFRAddNewBackMove(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/reDirfurnSpecsFullRmPackRevisedRendering")
	@ResponseBody
	public ModelAndView reDirfurnSpecsFullRmPackRevisedRendering(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRevisedRenderingFRAddNew")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNew(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFRAddNewRedirection(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRevisedRenderingFRDelete")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFRDelete(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFRDeleteInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/furnitureSpecsRevisedRenderingFREdit")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFREdit(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFREditInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/furnitureSpecsRevisedRenderingFREditedProdSaving")
	@ResponseBody
	public ModelAndView furnitureSpecsRevisedRenderingFREditedProdSaving(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest req, HttpSession sn) throws Exception {
		return designerInfoSavingService.furnitureSpecsRevisedRenderingFREditedProdSavingInDB(fileUpload, req, sn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/desnEditableCalendarForClients")
	@ResponseBody
	public ModelAndView desnEditableCalendarForClients(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerEditableCalendarForClients(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerClientNotesDataSaving")
	@ResponseBody
	public ModelAndView designerClientNotesDataSaving(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerClientNotesDataSavingInDB(req, sn);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/designerClientNotesDataTakeFromDB")
	@ResponseBody
	public ModelAndView designerClientNotesDataDisplay(HttpServletRequest req, HttpSession sn) {
		return designerInfoSavingService.designerClientNotesDataTakeFromDatabase(req, sn);
	}
	
}
