package com.home.project.service;

import com.home.project.entity.FileUpload;
import com.home.project.entity.PostEntity;
import com.home.project.repository.FileRepository;
import com.home.project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    FileRepository fileRepository;
    private final Path root = Paths.get("G://upload/file/");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public List<PostEntity> getAllByStatus(Integer status){


        return postRepository.getByStatus(status);
    }

    public PostEntity abcd(Long id, String userName){
        Optional<PostEntity> postEntityOp = postRepository.findById(id);

        if (postEntityOp.isPresent() && userName!=null){
            if (userName.equals("admin")){
                postEntityOp.get().setStatus(0);
                postEntityOp.get().setUser("admin");

            }else
            if (!postEntityOp.get().getUser().equals("admin")){
                 if (userName.equals("abc")){
                    postEntityOp.get().setStatus(1);
                    postEntityOp.get().setUser("abc");

                }else{
                    postEntityOp.get().setStatus(2);
                    postEntityOp.get().setUser("other");
                }
            }

            return postRepository.save( postEntityOp.get());
        }else {
            return  null;
        }
    }

    public void save(MultipartFile[] files) {
        try {



            List<FileUpload> fileList = new ArrayList<FileUpload>();
            for (MultipartFile file : files) {

//                String fileContentType = file.getContentType();
//                String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
//                String fileName = file.getOriginalFilename();
//                FileModal fileModal = new FileModal(fileName, sourceFileContent, fileContentType);
//
//                // Adding file into fileList
//                fileList.add(fileModal);
//
//                postService.save(file);
                try {
                    String fileName = file.getOriginalFilename();//full name of file submitted
                    String fileNameSplit = fileName.substring(fileName.lastIndexOf(".") + 1);//split between name and extension
                    System.out.println("extension  "+ fileNameSplit);
                    Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));

                }catch (Exception e){
                    e.printStackTrace();
                }


                FileUpload fileUpload = new FileUpload();
                fileUpload.setTitle(file.getOriginalFilename());
                fileUpload.setBody("Normal file Body.");
                fileUpload.setUrl(root + file.getOriginalFilename());
                fileRepository.save(fileUpload);

            }



        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
//            e.printStackTrace();
        }
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    public Resource loadById(Long id) {
        try {
            Optional<FileUpload> fileUpload = fileRepository.findById(id);
            if (fileUpload.isPresent()){
//                Path file = Paths.get(fileUpload.get().getUrl());
                Path file = root.resolve(fileUpload.get().getTitle());
                Resource resource = new UrlResource(file.toUri());

                if (resource.exists() || resource.isReadable()) {
                    return resource;
                } else {
                    throw new RuntimeException("Could not read the file!");
                }

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        throw new RuntimeException("Could not read the file!");
    }
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }
//    public void get(){
//        List<Object[]> reportTOs = postRepository.getCivilOfficerAndStaffDataByYear("");
//        if (reportTOs != null && !reportTOs.isEmpty()) {
//            for (Object[] reportObject : reportTOs) {
//                int i = 0;
//                for (Object rowObject : reportObject) {
//                    System.out.println(reportObject);
//                }
//            }
//        }
//    }



}
