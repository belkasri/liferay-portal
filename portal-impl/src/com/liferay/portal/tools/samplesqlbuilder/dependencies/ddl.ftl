<#if (maxDDLRecordSetCount > 0)>
	<#assign ddmStructureModel = dataFactory.newDDLDDMStructureModel(groupId)>

	insert into DDMStructure values ('${ddmStructureModel.uuid}', ${ddmStructureModel.structureId}, ${ddmStructureModel.groupId}, ${ddmStructureModel.companyId}, ${ddmStructureModel.userId}, '${ddmStructureModel.userName}', '${dataFactory.getDateString(ddmStructureModel.createDate)}', '${dataFactory.getDateString(ddmStructureModel.modifiedDate)}', ${ddmStructureModel.parentStructureId}, ${ddmStructureModel.classNameId}, '${ddmStructureModel.structureKey}', '${ddmStructureModel.name}', '${ddmStructureModel.description}', '${ddmStructureModel.xsd}', '${ddmStructureModel.storageType}', ${ddmStructureModel.type});

	<@insertResourcePermissions
		_entry = ddmStructureModel
	/>

	<#list 1..maxDDLRecordSetCount as ddlRecordSetCount>
		<#assign layoutName = "dynamic_data_list_display_" + ddlRecordSetCount>
		<#assign portletId = "169_INSTANCE_TEST" + ddlRecordSetCount>

		<#assign layoutModel = dataFactory.newLayoutModel(groupId, layoutName, "", portletId)>

		<@insertLayout
			_layoutModel = layoutModel
		/>

		<#assign ddlRecordSetModel = dataFactory.newDDLRecordSetModel(ddmStructureModel, ddlRecordSetCount)>

		insert into DDLRecordSet values ('${ddlRecordSetModel.uuid}', ${ddlRecordSetModel.recordSetId}, ${ddlRecordSetModel.groupId}, ${ddlRecordSetModel.companyId}, ${ddlRecordSetModel.userId}, '${ddlRecordSetModel.userName}', '${dataFactory.getDateString(ddlRecordSetModel.createDate)}', '${dataFactory.getDateString(ddlRecordSetModel.modifiedDate)}', ${ddlRecordSetModel.DDMStructureId}, '${ddlRecordSetModel.recordSetKey}', '${ddlRecordSetModel.name}', '${ddlRecordSetModel.description}', ${ddlRecordSetModel.minDisplayRows}, ${ddlRecordSetModel.scope});

		<@insertDDMStructureLink
			_entry = ddlRecordSetModel
		/>

		<@insertResourcePermissions
			_entry = ddlRecordSetModel
		/>

		<#if (maxDDLRecordCount > 0)>
			<#list 1..maxDDLRecordCount as ddlRecordCount>
				<#assign ddlRecordModel = dataFactory.newDDLRecordModel(ddlRecordSetModel)>

				insert into DDLRecord values ('${ddlRecordModel.uuid}', ${ddlRecordModel.recordId}, ${ddlRecordModel.groupId}, ${ddlRecordModel.companyId}, ${ddlRecordModel.userId}, '${ddlRecordModel.userName}', ${ddlRecordModel.versionUserId}, '${ddlRecordModel.versionUserName}', '${dataFactory.getDateString(ddlRecordModel.createDate)}', '${dataFactory.getDateString(ddlRecordModel.modifiedDate)}', ${ddlRecordModel.DDMStorageId}, ${ddlRecordModel.recordSetId}, '${ddlRecordModel.version}', ${ddlRecordModel.displayIndex});

				<#assign ddlRecordVersionModel = dataFactory.newDDLRecordVersionModel(ddlRecordModel)>

				insert into DDLRecordVersion values (${ddlRecordVersionModel.recordVersionId}, ${ddlRecordVersionModel.groupId}, ${ddlRecordVersionModel.companyId}, ${ddlRecordVersionModel.userId}, '${ddlRecordVersionModel.userName}', '${dataFactory.getDateString(ddlRecordVersionModel.createDate)}', ${ddlRecordVersionModel.DDMStorageId}, ${ddlRecordVersionModel.recordSetId}, ${ddlRecordVersionModel.recordId}, '${ddlRecordVersionModel.version}', ${ddlRecordVersionModel.displayIndex}, ${ddlRecordVersionModel.status}, ${ddlRecordVersionModel.statusByUserId}, '${ddlRecordVersionModel.statusByUserName}', '${dataFactory.getDateString(ddlRecordVersionModel.statusDate)}');

				<@insertDDMContent
					_currentIndex = ddlRecordCount
					_ddmStorageLinkId = counter.get()
					_ddmStructureId = ddmStructureModel.structureId
					_entry = ddlRecordModel
				/>

				${writerDynamicDataListsCSV.write(ddlRecordModel.groupId + "," + layoutName + "," + portletId + "," + ddlRecordSetModel.recordSetId + "," + ddlRecordModel.recordId + "\n")}
			</#list>
		</#if>

		<#assign portletPreferencesModel = dataFactory.newPortletPreferencesModel(layoutModel.plid, portletId, ddlRecordSetModel)>

		<@insertPortletPreferences
			_portletPreferencesModel = portletPreferencesModel
		/>

		<#assign portletPreferencesModels = dataFactory.newPortletPreferencesModels(layoutModel.plid)>

		<#list portletPreferencesModels as portletPreferencesModel>
			<@insertPortletPreferences
				_portletPreferencesModel = portletPreferencesModel
			/>
		</#list>
	</#list>
</#if>