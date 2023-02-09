package com.home.project.controller;


import com.fasterxml.jackson.databind.util.BeanUtil;
import com.home.project.dto.FileInfo;
import com.home.project.dto.ResponseMessage;
import com.home.project.entity.PostCategory;
import com.home.project.entity.PostEntity;
import com.home.project.repository.PostCategoryRepository;
import com.home.project.repository.PostRepository;
import com.home.project.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@CrossOrigin("*")
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;

    @Autowired
    PostService postService;
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/posts")
    List<PostEntity> all() {

        System.out.println("Get All called");
        return postRepository.findAll();
    }

    @GetMapping("/getPosts/{id}")
    List<PostEntity> allByStatus(@PathVariable Integer id) {
        return postService.getAllByStatus(id);
    }
    // end::get-aggregate-root[]

    @PostMapping("/posts")
    PostEntity newPost(@RequestBody PostEntity newEmployee) {


        PostCategory pq;
        pq = postCategoryRepository.save(newEmployee.getPostCategory());
        newEmployee.setPostCategory(pq);
        return postRepository.save(newEmployee);
    }

    // Single item

    @GetMapping("/posts/{id}")
    PostEntity one(@PathVariable Long id) {
        Optional<PostEntity> postEntity =  postRepository.findById(id);

        List<PostEntity> postEntities = postRepository.findPostEntitiesByTitle(postEntity.get().getTitle());

        List<String> bodies = postRepository.findPostEntityBodyByTitle(postEntity.get().getTitle());
        for (String s:bodies
        ) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------");
        for (PostEntity p:postEntities
             ) {
            System.out.println(p.toString());
        }
        return postEntity.get();
    }

    @PutMapping("/posts/{id}")
    PostEntity replaceEmployee(@RequestBody PostEntity postEntity, @PathVariable Long id) {

        return postRepository.findById(id)
                .map(post -> {
//                    BeanUtils.copyProperties(postEntity,post);
                    post.setTitle(postEntity.getTitle());
                    post.setBody(postEntity.getBody());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    postEntity.setId(id);
                    return postRepository.save(postEntity);
                });
    }


    @PutMapping("/updatePosts/{id}")
    PostEntity updateStatusById(@PathVariable Long id, @RequestParam(value = "user") String userName) {

        return  postService.abcd(id,userName);
//        return postRepository.findById(id)
//                .map(post -> {
//                    if (userName!=null && userName.equals("admin")){
//                        post.setTitle("false");
//                    }else {
//                        post.setTitle("true");
//                    }
//                    return postRepository.save(post);
//                })
//                .orElseGet(() -> {
//                    return null;
//                });
    }



    @GetMapping("/deletePosts/{id}")
    String deleteEmployeeStringReturn(@PathVariable Long id) {
        String message = "Success";
        postRepository.deleteById(id);
        return message;

    }

    @DeleteMapping("/posts/{id}")
    ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Success Delete"));

    }

//    @PostMapping("/upload")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "abc") String abc) {
//        String message = "";
//        try {
//            postService.save(file);
//            message = "Uploaded the file successfully: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//        } catch (Exception e) {
//            message = "Could not upload the file: " + file.getOriginalFilename()
//                    + ". Error: " + e.getMessage();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//        }
//    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile[] file, @RequestParam("id") Long id) {
        String message = "";
        try {

            System.out.println(id);
            postService.save(file);
            message = "Uploaded the file successfully. " ;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = postService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/filesById/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable Long id) {
        Resource file = postService.loadById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = postService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(PostController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @DeleteMapping("/files/{filename:.+}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String filename) {
        String message = "";

        try {
            boolean existed = postService.delete(filename);
            if (existed) {
                message = "Delete the file successfully: " + filename;
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }

            message = "The file does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message));
        }
    }

}

