/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.documentlibrary.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileEntryService;
import com.liferay.portlet.documentlibrary.service.DLFileRankLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutService;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderService;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileRankFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileRankPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileVersionPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence;

import java.util.List;

/**
 * <a href="DLFileShortcutLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class DLFileShortcutLocalServiceBaseImpl
	implements DLFileShortcutLocalService {
	public DLFileShortcut addDLFileShortcut(DLFileShortcut dlFileShortcut)
		throws SystemException {
		dlFileShortcut.setNew(true);

		return dlFileShortcutPersistence.update(dlFileShortcut, false);
	}

	public DLFileShortcut createDLFileShortcut(long fileShortcutId) {
		return dlFileShortcutPersistence.create(fileShortcutId);
	}

	public void deleteDLFileShortcut(long fileShortcutId)
		throws PortalException, SystemException {
		dlFileShortcutPersistence.remove(fileShortcutId);
	}

	public void deleteDLFileShortcut(DLFileShortcut dlFileShortcut)
		throws SystemException {
		dlFileShortcutPersistence.remove(dlFileShortcut);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dlFileShortcutPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return dlFileShortcutPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	public DLFileShortcut getDLFileShortcut(long fileShortcutId)
		throws PortalException, SystemException {
		return dlFileShortcutPersistence.findByPrimaryKey(fileShortcutId);
	}

	public List<DLFileShortcut> getDLFileShortcuts(int start, int end)
		throws SystemException {
		return dlFileShortcutPersistence.findAll(start, end);
	}

	public int getDLFileShortcutsCount() throws SystemException {
		return dlFileShortcutPersistence.countAll();
	}

	public DLFileShortcut updateDLFileShortcut(DLFileShortcut dlFileShortcut)
		throws SystemException {
		dlFileShortcut.setNew(false);

		return dlFileShortcutPersistence.update(dlFileShortcut, true);
	}

	public DLFileEntryLocalService getDLFileEntryLocalService() {
		return dlFileEntryLocalService;
	}

	public void setDLFileEntryLocalService(
		DLFileEntryLocalService dlFileEntryLocalService) {
		this.dlFileEntryLocalService = dlFileEntryLocalService;
	}

	public DLFileEntryService getDLFileEntryService() {
		return dlFileEntryService;
	}

	public void setDLFileEntryService(DLFileEntryService dlFileEntryService) {
		this.dlFileEntryService = dlFileEntryService;
	}

	public DLFileEntryPersistence getDLFileEntryPersistence() {
		return dlFileEntryPersistence;
	}

	public void setDLFileEntryPersistence(
		DLFileEntryPersistence dlFileEntryPersistence) {
		this.dlFileEntryPersistence = dlFileEntryPersistence;
	}

	public DLFileEntryFinder getDLFileEntryFinder() {
		return dlFileEntryFinder;
	}

	public void setDLFileEntryFinder(DLFileEntryFinder dlFileEntryFinder) {
		this.dlFileEntryFinder = dlFileEntryFinder;
	}

	public DLFileRankLocalService getDLFileRankLocalService() {
		return dlFileRankLocalService;
	}

	public void setDLFileRankLocalService(
		DLFileRankLocalService dlFileRankLocalService) {
		this.dlFileRankLocalService = dlFileRankLocalService;
	}

	public DLFileRankPersistence getDLFileRankPersistence() {
		return dlFileRankPersistence;
	}

	public void setDLFileRankPersistence(
		DLFileRankPersistence dlFileRankPersistence) {
		this.dlFileRankPersistence = dlFileRankPersistence;
	}

	public DLFileRankFinder getDLFileRankFinder() {
		return dlFileRankFinder;
	}

	public void setDLFileRankFinder(DLFileRankFinder dlFileRankFinder) {
		this.dlFileRankFinder = dlFileRankFinder;
	}

	public DLFileShortcutLocalService getDLFileShortcutLocalService() {
		return dlFileShortcutLocalService;
	}

	public void setDLFileShortcutLocalService(
		DLFileShortcutLocalService dlFileShortcutLocalService) {
		this.dlFileShortcutLocalService = dlFileShortcutLocalService;
	}

	public DLFileShortcutService getDLFileShortcutService() {
		return dlFileShortcutService;
	}

	public void setDLFileShortcutService(
		DLFileShortcutService dlFileShortcutService) {
		this.dlFileShortcutService = dlFileShortcutService;
	}

	public DLFileShortcutPersistence getDLFileShortcutPersistence() {
		return dlFileShortcutPersistence;
	}

	public void setDLFileShortcutPersistence(
		DLFileShortcutPersistence dlFileShortcutPersistence) {
		this.dlFileShortcutPersistence = dlFileShortcutPersistence;
	}

	public DLFileShortcutFinder getDLFileShortcutFinder() {
		return dlFileShortcutFinder;
	}

	public void setDLFileShortcutFinder(
		DLFileShortcutFinder dlFileShortcutFinder) {
		this.dlFileShortcutFinder = dlFileShortcutFinder;
	}

	public DLFileVersionLocalService getDLFileVersionLocalService() {
		return dlFileVersionLocalService;
	}

	public void setDLFileVersionLocalService(
		DLFileVersionLocalService dlFileVersionLocalService) {
		this.dlFileVersionLocalService = dlFileVersionLocalService;
	}

	public DLFileVersionPersistence getDLFileVersionPersistence() {
		return dlFileVersionPersistence;
	}

	public void setDLFileVersionPersistence(
		DLFileVersionPersistence dlFileVersionPersistence) {
		this.dlFileVersionPersistence = dlFileVersionPersistence;
	}

	public DLFolderLocalService getDLFolderLocalService() {
		return dlFolderLocalService;
	}

	public void setDLFolderLocalService(
		DLFolderLocalService dlFolderLocalService) {
		this.dlFolderLocalService = dlFolderLocalService;
	}

	public DLFolderService getDLFolderService() {
		return dlFolderService;
	}

	public void setDLFolderService(DLFolderService dlFolderService) {
		this.dlFolderService = dlFolderService;
	}

	public DLFolderPersistence getDLFolderPersistence() {
		return dlFolderPersistence;
	}

	public void setDLFolderPersistence(DLFolderPersistence dlFolderPersistence) {
		this.dlFolderPersistence = dlFolderPersistence;
	}

	public DLFolderFinder getDLFolderFinder() {
		return dlFolderFinder;
	}

	public void setDLFolderFinder(DLFolderFinder dlFolderFinder) {
		this.dlFolderFinder = dlFolderFinder;
	}

	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public CounterService getCounterService() {
		return counterService;
	}

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public UserFinder getUserFinder() {
		return userFinder;
	}

	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService.impl")
	protected DLFileEntryLocalService dlFileEntryLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileEntryService.impl")
	protected DLFileEntryService dlFileEntryService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryPersistence.impl")
	protected DLFileEntryPersistence dlFileEntryPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryFinder.impl")
	protected DLFileEntryFinder dlFileEntryFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileRankLocalService.impl")
	protected DLFileRankLocalService dlFileRankLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileRankPersistence.impl")
	protected DLFileRankPersistence dlFileRankPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileRankFinder.impl")
	protected DLFileRankFinder dlFileRankFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileShortcutLocalService.impl")
	protected DLFileShortcutLocalService dlFileShortcutLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileShortcutService.impl")
	protected DLFileShortcutService dlFileShortcutService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutPersistence.impl")
	protected DLFileShortcutPersistence dlFileShortcutPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutFinder.impl")
	protected DLFileShortcutFinder dlFileShortcutFinder;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFileVersionLocalService.impl")
	protected DLFileVersionLocalService dlFileVersionLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFileVersionPersistence.impl")
	protected DLFileVersionPersistence dlFileVersionPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFolderLocalService.impl")
	protected DLFolderLocalService dlFolderLocalService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.DLFolderService.impl")
	protected DLFolderService dlFolderService;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence.impl")
	protected DLFolderPersistence dlFolderPersistence;
	@javax.annotation.Resource(name = "com.liferay.portlet.documentlibrary.service.persistence.DLFolderFinder.impl")
	protected DLFolderFinder dlFolderFinder;
	@javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
	protected CounterLocalService counterLocalService;
	@javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
	protected CounterService counterService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.ResourceLocalService.impl")
	protected ResourceLocalService resourceLocalService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.ResourceService.impl")
	protected ResourceService resourceService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
	protected ResourcePersistence resourcePersistence;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.ResourceFinder.impl")
	protected ResourceFinder resourceFinder;
	@javax.annotation.Resource(name = "com.liferay.portal.service.UserLocalService.impl")
	protected UserLocalService userLocalService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.UserService.impl")
	protected UserService userService;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
	protected UserPersistence userPersistence;
	@javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserFinder.impl")
	protected UserFinder userFinder;
}