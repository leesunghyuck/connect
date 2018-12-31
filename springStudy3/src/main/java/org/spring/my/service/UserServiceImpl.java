package org.spring.my.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.spring.my.dao.UserRepository;
import org.spring.my.domain.User;
import org.spring.my.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean updateProfileImage(int userIdx, MultipartFile photo) {

		byte [] photoBytes = null;

		try {
			photoBytes = photo.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		Calendar cal = Calendar.getInstance();
		String folderName = String.format("%04d_%02d_%02d", cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE));

		File folder = new File(FileUtil.USER_PROFILE_IMAGE_FOLDER_PATH + "/" + folderName);

		if(!folder.exists()) {
			folder.mkdir();
		}

		String randomString = UUID.randomUUID().toString().replaceAll("-", "");
		String fileExtension = null;

		if(FileUtil.isJpg(photoBytes)) {
			fileExtension = ".jpg";
		} else if(FileUtil.isPng(photoBytes)) {
			fileExtension = ".png";
		} else if(FileUtil.isGif(photoBytes)) {
			fileExtension = ".gif";
		} else {
			return false;
		}


		/*int fileDotIndex = photo.getOriginalFilename().lastIndexOf(".");

		if(fileDotIndex >= 0 && photo.getOriginalFilename().length() > fileDotIndex + 1) {
			fileExtension = "." + photo.getOriginalFilename().substring(fileDotIndex + 1);
		}*/

		String fileName = String.format("%d_%s.%s", cal.getTimeInMillis(), randomString, fileExtension);

		File file = new File(folder.getAbsolutePath() + "/" + fileName);

		try {
			FileCopyUtils.copy(photoBytes, file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<User> selectAllUser() {

		return userRepository.selectAllUser();
	}

}
