package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.dao.PriorityDAO;
import com.acc.dao.ProgressDAO;
import com.acc.dto.PinCodeDTO;
import com.acc.dto.PriorityDTO;
import com.acc.entity.PinCodeEntity;
import com.acc.entity.PriorityEntity;
import com.acc.entity.ProgressEntity;

@Profile("MSD_Dev_Profile")
@Repository
public class PriorityServiceImpl {
	Logger log = Logger.getLogger(PriorityServiceImpl.class);
	@Autowired
	private PriorityDAO priorityDAO;

	@Autowired
	private ProgressDAO progressDAO;

	public List<PriorityDTO> getAllDetails() throws Exception {
		List<PriorityDTO> list = new ArrayList<PriorityDTO>();
		try {
			Iterable<ProgressEntity> entity = progressDAO.findByActive("true");

			entity.forEach(x -> {
				PriorityDTO dto = new PriorityDTO();
				BeanUtils.copyProperties(x, dto);
				BeanUtils.copyProperties(x.getPriorityEntity(), dto);
				list.add(dto);
			});
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
		return list;

	}

	public Integer addPriority(PriorityDTO dto) throws Exception {
		try {
			PriorityEntity priorityEntity = new PriorityEntity();
			ProgressEntity progressEntity = new ProgressEntity();

			BeanUtils.copyProperties(dto, priorityEntity);
			progressEntity.setPriorityEntity(priorityEntity);

			BeanUtils.copyProperties(dto, progressEntity);

			ProgressEntity id = progressDAO.save(progressEntity);
			return id.getPriorityEntity().getPid();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

	public Integer updatePriority(PriorityDTO dto) throws Exception {
		Object obj = null;
		try {
			PriorityEntity priorityEntity = priorityDAO.findOne(dto.getPid());
			ProgressEntity progressEntity = new ProgressEntity();
			if (priorityEntity != null) {
				BeanUtils.copyProperties(dto, priorityEntity);
				PriorityEntity temp1 = priorityDAO.save(priorityEntity);
				System.out.println("****" + temp1);
				BeanUtils.copyProperties(dto, progressEntity);
				progressEntity.setPriorityEntity(temp1);
				System.out.println("****2" + progressEntity);
				obj = progressDAO.save(progressEntity);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}

		if (obj != null)
			return 1;
		else
			return 0;
	}

	public void deletePriority(int uid) {
		try {
			String statusChange = "false";

			ProgressEntity progressEntity = progressDAO
					.findProgressByPriorityId(uid);
			progressEntity.setActive(statusChange);
			// progressEntity.setPriorityEntity(priorityEntity);
			progressDAO.save(progressEntity);

			PriorityEntity priorityEntity = priorityDAO.findByPid(uid);
			priorityEntity.setIsActive(statusChange);
			progressEntity.setPriorityEntity(priorityEntity);
			priorityDAO.save(priorityEntity);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public Boolean findByPid(int id) {
		PriorityEntity entity = new PriorityEntity();
		try {
			entity = priorityDAO.findByPid(id);
			if (entity == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

	public PriorityEntity findByStatus(int id) {
		PriorityEntity entity = new PriorityEntity();
		try {
			entity = priorityDAO.findByStatus(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return entity;

	}

	public void hardDeletePriority(int uid) {
		try {

			ProgressEntity progressEntity = progressDAO
					.findProgressByPriorityId(uid);

			progressDAO.delete(progressEntity);

			PriorityEntity priorityEntity = priorityDAO.findByPid(uid);
			priorityDAO.delete(priorityEntity);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public PriorityDTO getPriorityById(int id) throws Exception {
		PriorityDTO priorityDTO = null;

		try {
			ProgressEntity progressEntity = progressDAO
					.findProgressByPriorityId(id);
			PriorityEntity priorityEntity = priorityDAO.findOne(id);
			if (progressEntity != null && priorityEntity != null) {
				priorityDTO = new PriorityDTO();
				BeanUtils.copyProperties(progressEntity, priorityDTO);
				BeanUtils.copyProperties(priorityEntity, priorityDTO);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

		return priorityDTO;

	}

}