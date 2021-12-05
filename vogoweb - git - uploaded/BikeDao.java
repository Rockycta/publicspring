package com.vogo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vogo.bo.BikeBo;
import com.vogo.bo.BikeSearchBo;

@Repository
public class BikeDao {
	private final String SQL_GET_BIKES = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike order by bike_no";
	private final String SQL_SEARCH_BIKES = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike";
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public List<BikeBo> getBikes() {
		return npJdbcTemplate.query(SQL_GET_BIKES, (rs, rowNum) -> {
			return mapBikeBo(rs);
		});
	}

	public List<BikeBo> searchBikes(BikeSearchBo bikeSearchBo) {
		String sql = null;
		StringBuilder whereClause = null;
		MapSqlParameterSource mapSqlParameterSource = null;

		whereClause = new StringBuilder();
		mapSqlParameterSource = new MapSqlParameterSource();

		if (bikeSearchBo.getModelName() != null && bikeSearchBo.getModelName().trim().length() > 0) {
			whereClause
					.append(whereClause.isEmpty() ? " where bike_model_nm=:modelName" : " or bike_model_nm=:modelName");
			mapSqlParameterSource.addValue("modelName", bikeSearchBo.getModelName());
		}

		if (bikeSearchBo.getManufacturer() != null && bikeSearchBo.getManufacturer().trim().length() > 0) {
			whereClause.append(
					whereClause.isEmpty() ? " where manufacturer=:manufacturer" : " or manufacturer=:manufacturer");
			mapSqlParameterSource.addValue("manufacturer", bikeSearchBo.getManufacturer());

		}

		if (bikeSearchBo.getRtaRegistrationNo() != null && bikeSearchBo.getRtaRegistrationNo().trim().length() > 0) {
			whereClause.append(whereClause.isEmpty() ? " where rta_registration_no=:rta_registration_no"
					: " or rta_registration_no=:rta_registration_no");
			mapSqlParameterSource.addValue("rta_registration_no", bikeSearchBo.getRtaRegistrationNo());
		}

		if (bikeSearchBo.getMinPrice() > 0 && bikeSearchBo.getMaxPrice() > 0) {
			whereClause.append(whereClause.isEmpty() ? " where price between :minPrice and :maxPrice"
					: " or price between :minPrice and :maxPrice");

			mapSqlParameterSource.addValue("minPrice", bikeSearchBo.getMinPrice());
			mapSqlParameterSource.addValue("maxPrice", bikeSearchBo.getMaxPrice());
		}
		sql = SQL_SEARCH_BIKES + whereClause.toString();

		return npJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) -> {
			return mapBikeBo(rs);
		});
	}

	private BikeBo mapBikeBo(ResultSet rs) throws SQLException {
		BikeBo bo = new BikeBo();

		bo.setBikeNo(rs.getInt(1));
		bo.setBikeModelName(rs.getString(2));
		bo.setManufacturer(rs.getString(3));
		bo.setRtaRegistrationNumber(rs.getString(4));
		bo.setPrice(rs.getDouble(5));
		return bo;
	}
}
