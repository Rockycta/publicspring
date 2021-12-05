package com.vogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.vogo.bo.BikeBo;
import com.vogo.bo.BikeSearchBo;

@Repository
public class BikeDao {
	private final String SQL_GET_BIKES = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike order by bike_no";
	private final String SQL_SEARCH_BIKES = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike";
	private final String SQL_GET_BIKE = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike where bike_no=:bikeNo";
	private final String SQL_SAVE_BIKE = "insert into bike(bike_model_nm, manufacturer, rta_registration_no, price) values(:modelName, :manufacturer, :rtaNo, :price)";
	private final String SQL_UPDATE_BIKE = "update bike set bike_model_nm=:bikeModelName, manufacturer=:manufacturer, rta_registration_no=:rtaNo, price=:price where bike_no = :bikeNo";

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public List<BikeBo> getBikes() {
		return npJdbcTemplate.query(SQL_GET_BIKES, (rs, rowNum) -> {
			return mapBikeBo(rs);
		});
	}

	public BikeBo getBike(int bikeNo) {
		SqlParameterSource paramSource = new MapSqlParameterSource("bikeNo", bikeNo);
		return npJdbcTemplate.queryForObject(SQL_GET_BIKE, paramSource, (rs, rowNum) -> {
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

	public long saveBike(BikeBo bikeBo) {
		long bikeNo = 0;
		KeyHolder keyHolder = null;
		MapSqlParameterSource parameterSource = null;

		parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("modelName", bikeBo.getBikeModelName());
		parameterSource.addValue("manufacturer", bikeBo.getManufacturer());
		parameterSource.addValue("rtaNo", bikeBo.getRtaRegistrationNumber());
		parameterSource.addValue("price", bikeBo.getPrice());

		keyHolder = new GeneratedKeyHolder();
		npJdbcTemplate.update(SQL_SAVE_BIKE, parameterSource, keyHolder);
		bikeNo = keyHolder.getKey().longValue();

		return bikeNo;
	}
	
	public void updateBike(BikeBo bikeBo) {
		MapSqlParameterSource parameterSource = null;

		parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("bikeNo", bikeBo.getBikeNo());
		parameterSource.addValue("bikeModelName", bikeBo.getBikeModelName());
		parameterSource.addValue("manufacturer", bikeBo.getManufacturer());
		parameterSource.addValue("rtaNo", bikeBo.getRtaRegistrationNumber());
		parameterSource.addValue("price", bikeBo.getPrice());
		npJdbcTemplate.update(SQL_UPDATE_BIKE, parameterSource);
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
