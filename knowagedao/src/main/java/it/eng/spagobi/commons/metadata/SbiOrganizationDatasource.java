/*
 * Knowage, Open Source Business Intelligence suite
 * Copyright (C) 2016 Engineering Ingegneria Informatica S.p.A.
 * 
 * Knowage is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Knowage is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.eng.spagobi.commons.metadata;

// Generated 20-nov-2013 15.29.05 by Hibernate Tools 3.4.0.CR1

import it.eng.spagobi.tools.datasource.metadata.SbiDataSource;

import java.util.Date;

/**
 * SbiOrganizationDatasource generated by hbm2java
 */
public class SbiOrganizationDatasource extends SbiHibernateModel  {

	private SbiOrganizationDatasourceId id;
	private SbiDataSource sbiDataSource;
	private SbiTenant sbiOrganizations;
	private String userIn;
	private String userUp;
	private String userDe;
	private Date timeIn;
	private Date timeUp;
	private Date timeDe;
	private String sbiVersionIn;
	private String sbiVersionUp;
	private String sbiVersionDe;
	private String metaVersion;

	public SbiOrganizationDatasource() {
	}

	public SbiOrganizationDatasource(SbiOrganizationDatasourceId id,
			SbiDataSource sbiDataSource, SbiTenant sbiOrganizations,
			String userIn, Date timeIn) {
		this.id = id;
		this.sbiDataSource = sbiDataSource;
		this.sbiOrganizations = sbiOrganizations;
		this.userIn = userIn;
		this.timeIn = timeIn;
	}

	public SbiOrganizationDatasource(SbiOrganizationDatasourceId id,
			SbiDataSource sbiDataSource, SbiTenant sbiOrganizations,
			String userIn,
			String userUp, String userDe, Date timeIn, Date timeUp,
			Date timeDe, String sbiVersionIn, String sbiVersionUp,
			String sbiVersionDe, String metaVersion) {
		this.id = id;
		this.sbiDataSource = sbiDataSource;
		this.sbiOrganizations = sbiOrganizations;
		this.userIn = userIn;
		this.userUp = userUp;
		this.userDe = userDe;
		this.timeIn = timeIn;
		this.timeUp = timeUp;
		this.timeDe = timeDe;
		this.sbiVersionIn = sbiVersionIn;
		this.sbiVersionUp = sbiVersionUp;
		this.sbiVersionDe = sbiVersionDe;
		this.metaVersion = metaVersion;
	}

	public SbiOrganizationDatasourceId getId() {
		return this.id;
	}

	public void setId(SbiOrganizationDatasourceId id) {
		this.id = id;
	}

	public SbiDataSource getSbiDataSource() {
		return this.sbiDataSource;
	}

	public void setSbiDataSource(SbiDataSource sbiDataSource) {
		this.sbiDataSource = sbiDataSource;
	}

	public SbiTenant getSbiOrganizations() {
		return this.sbiOrganizations;
	}

	public void setSbiOrganizations(SbiTenant sbiOrganizations) {
		this.sbiOrganizations = sbiOrganizations;
	}

	public String getUserIn() {
		return this.userIn;
	}

	public void setUserIn(String userIn) {
		this.userIn = userIn;
	}

	public String getUserUp() {
		return this.userUp;
	}

	public void setUserUp(String userUp) {
		this.userUp = userUp;
	}

	public String getUserDe() {
		return this.userDe;
	}

	public void setUserDe(String userDe) {
		this.userDe = userDe;
	}

	public Date getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeUp() {
		return this.timeUp;
	}

	public void setTimeUp(Date timeUp) {
		this.timeUp = timeUp;
	}

	public Date getTimeDe() {
		return this.timeDe;
	}

	public void setTimeDe(Date timeDe) {
		this.timeDe = timeDe;
	}

	public String getSbiVersionIn() {
		return this.sbiVersionIn;
	}

	public void setSbiVersionIn(String sbiVersionIn) {
		this.sbiVersionIn = sbiVersionIn;
	}

	public String getSbiVersionUp() {
		return this.sbiVersionUp;
	}

	public void setSbiVersionUp(String sbiVersionUp) {
		this.sbiVersionUp = sbiVersionUp;
	}

	public String getSbiVersionDe() {
		return this.sbiVersionDe;
	}

	public void setSbiVersionDe(String sbiVersionDe) {
		this.sbiVersionDe = sbiVersionDe;
	}

	public String getMetaVersion() {
		return this.metaVersion;
	}

	public void setMetaVersion(String metaVersion) {
		this.metaVersion = metaVersion;
	}

}
