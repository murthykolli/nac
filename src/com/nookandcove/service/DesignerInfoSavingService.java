package com.nookandcove.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface DesignerInfoSavingService {
	
	public ModelAndView designerAccountRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView uploadDesInfoSavingInDB(HttpServletRequest req, HttpSession sn);	
	public ModelAndView uploadDesignerProfileInDBTables(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;	
	public ModelAndView reLoadDesignerUploadImagesInDBTables(HttpServletRequest req, HttpSession sn);	
	public ModelAndView designerClientsRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerClientsArchiveRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerClArchiveDataUpdateInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView messageForAdminRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView viewClientInformationForDesigner(HttpServletRequest req, HttpSession sn, String clentInfoId, String desInfoId);	
	public ModelAndView viewClientMessageInformation(HttpServletRequest req, HttpSession sn, String clentInfoId, String desInfoId);
	public ModelAndView viewArchiveClientsInformation(HttpServletRequest req, HttpSession sn, String clientsInfoIdStr, String designersInfoIdStr);
	public ModelAndView viewClientMessageRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accDesignerUploadConcept1ImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;	
	public ModelAndView accDesignerUploadConcept2ImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;	
	public ModelAndView accDesignerUploadFinalConceptImageInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView viewMsgInfoValuesMaintainInSn(HttpServletRequest req, HttpSession sn, String clentInfoId);	
	public ModelAndView designerUpdateAccPackCheckListInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerUpdateFullPackCheckListInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerMessageSendToClientRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerOneTimeSentMailToClient(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerAndClientMessageInfoRedirection(HttpServletRequest req, HttpSession sn);	
	public ModelAndView designerMessageSendToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerOneTimeSentMailToAdmin(HttpServletRequest req, HttpSession sn);
	public ModelAndView adminAndDesignerMessageInfoRedirection(HttpServletRequest req, HttpSession sn);	
	public String customerNameFromDB(long userId);	
	public String designerPhoneNumberFromDB(long userId);	
	public int clientMessagesCountInDesnSideTakeFromDB(long clientInfoId, long designerInfoId);
	
	public ModelAndView designerSideAccessoriesPackageRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSideFullRoomDesignPackageRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accBudgetManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accDimensionsManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accColorManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accFurnitureManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accArtManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accMyRoomManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView accInspirationManagementRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fullBudgetManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullDimensionsManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullColorManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullFurnitureManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullArtManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullMyRoomManagementRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullInspirationManagementRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView desnUploadAccPackConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn);
	public String concept3DRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	public ModelAndView desnUploadFullRoomConceptsAndRenderingsRedirection(HttpServletRequest req, HttpSession sn);
	public String fullRoomUploadConcept1ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId);
	public String fullRoomUploadRoomRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId);
	public String fullRoomUploadRevRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId);
	public String fullRoomUploadSecRend2ImagesTakefromInDB(HttpServletRequest req, HttpSession sn, long clientInfoId, long designerInfoId);
	public String conceptRevisedRenderingLikeImagesDisplay(HttpServletRequest req, HttpSession sn, long clientInfoId, long designInfoId);
	
	public ModelAndView designerSubmitAccPackConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSubmitAccPackFinalConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fullRoomUploadConcept1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadConcept2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadRendering1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadRendering2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadRevRendering1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadRevRendering2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView designerMessageForClientRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerNotesDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerNotesDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullRoomDesignerNotesDisplayRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullRoomDesignerNotesDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView fullRoomUploadSecRendConcept1ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView fullRoomUploadSecRendConcept2ImagesInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView designerSubmitFullRoomConceptsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSubmitFullRoomRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSubmitFullRoomRevisedRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerSubmitFullRoom2ndRenderingsToAdminRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView furnitureSpecsConcepts1ProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFRDisplayBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1FRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView reDirfurnSpecsCon1FullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1FRAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsCon1FRAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1FRDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1FREditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1FREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsConcepts2ProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsCon2FullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2FRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsCon2FRAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2FRAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2FRDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2FREditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2FREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsRoomRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsRoomRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRoomRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsRoomRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRoomRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRoomRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRoomRenderingFREditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRoomRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecs2ndRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecs2ndRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecs2ndRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecs2ndRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecs2ndRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecs2ndRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecs2ndRenderingFREditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecs2ndRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsRevisedRenderingProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsRevisedRenderingFullRmPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRevisedRenderingFRProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRevisedRenderingFRAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRevisedRenderingFRDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRevisedRenderingFREditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsRevisedRenderingFREditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsConcepts1AccPackProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsCon1AccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsAccPackDisplayBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1AccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsCon1AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1AccPackAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1AccPackDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1AccPackEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts1AccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsConcepts2AccPackProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsCon2AccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2AccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsCon2AccPackAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2AccPackAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2AccPackDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2AccPackEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsConcepts2AccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	
	public ModelAndView furnitureSpecsFinalConceptProductsUploadRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView reDirfurnSpecsFinalConceptAccPackRetrieveFromDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFinalConceptAccPackProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNewBackMove(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFinalConceptAccPackAddNewRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFinalConceptAccPackDeleteInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFinalConceptAccPackEditInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView furnitureSpecsFinalConceptAccPackEditedProdSavingInDB(MultipartFile fileDesnUpload, HttpServletRequest req, HttpSession sn) throws Exception;
	public String clientNewAlertRequestRedirection(long clientInfoId, long designerInfoId);
	public ModelAndView deisgnerFirstTimeClientRequestRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView newClientRequestToAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView newClientRequestCancelFromAdminRedirection(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnAccPackApprovedMailSentToAdmin(HttpServletRequest req, HttpSession sn);
	public ModelAndView desnFullRoomPackApprovedMailSentToAdmin(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerEditableCalendarForClients(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerEditableCalendarCreateForClients(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerClientNotesDataSavingInDB(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerClientNotesDataTakeFromDatabase(HttpServletRequest req, HttpSession sn);
	public ModelAndView designerClientNotesDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();	
	public String timeGettingFromCurrentDate();	
	public String todayDateGettingFromCurrentDate();
}
