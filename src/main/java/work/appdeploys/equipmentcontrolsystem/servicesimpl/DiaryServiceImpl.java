package work.appdeploys.equipmentcontrolsystem.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.appdeploys.equipmentcontrolsystem.constants.MessageResource;
import work.appdeploys.equipmentcontrolsystem.exceptions.DiaryExceptionBadRequest;
import work.appdeploys.equipmentcontrolsystem.exceptions.OrdersExceptionBadRequest;
import work.appdeploys.equipmentcontrolsystem.exceptions.SchoolExceptionBadRequest;
import work.appdeploys.equipmentcontrolsystem.mappers.DiaryMapper;
import work.appdeploys.equipmentcontrolsystem.models.Diary;
import work.appdeploys.equipmentcontrolsystem.models.School;
import work.appdeploys.equipmentcontrolsystem.models.Users;
import work.appdeploys.equipmentcontrolsystem.models.dtos.DiaryDto;
import work.appdeploys.equipmentcontrolsystem.repositories.DiaryRepository;
import work.appdeploys.equipmentcontrolsystem.repositories.SchoolRepository;
import work.appdeploys.equipmentcontrolsystem.repositories.UsersRepository;
import work.appdeploys.equipmentcontrolsystem.services.DiaryService;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {

    private final DiaryMapper diaryMapper;

    private final DiaryRepository diaryRepository;

    private final SchoolRepository schoolRepository;

    private final UsersRepository usersRepository;

    @Override
    public DiaryDto save(DiaryDto diaryDto) {
        if(diaryRepository.findById(diaryDto.getId()).isPresent()){
            throw new DiaryExceptionBadRequest(MessageResource.DIARY_EXIST_NOT_SAVE.getValue());
        }

        validateDiaryFields(diaryDto);
        Diary diary;
        try{
            diary = diaryMapper.toModel(diaryDto);
            diary.setSchool(validateSchoolById(diaryDto.getSchool().getId(),MessageResource.SCHOOL_EXIST_NOT_SAVE.getValue()));
            diary.setUser(validateUsersById(diaryDto.getUser().getId(), MessageResource.USER_CREATE_ORDER_NOT_EXIST_NOT_SAVE.getValue()));
            diary.setId(null);
            diaryRepository.save(diary);
        }catch (Exception ex){
            throw new DiaryExceptionBadRequest(ex.getMessage());
        }

        return diaryMapper.toDto(diary);
    }

    @Override
    public void delete(long id) {
        validateDiary(id,MessageResource.DIARY_NOT_EXIST_NOT_DELETE.getValue());
        diaryRepository.deleteAllById(Collections.singleton(id));
    }

    @Override
    public DiaryDto update(DiaryDto diaryDto) {
        validateDiaryFields(diaryDto);
        validateDiary(diaryDto.getId(),MessageResource.DIARY_NOT_EXIST_NOT_UPDATE.getValue());
        return diaryMapper.toDto(diaryRepository.save(diaryMapper.toModel(diaryDto)));
    }

    @Override
    public List<DiaryDto> findByAll() {
        List<Diary> list = diaryRepository.findAll();
        if(!list.isEmpty()){
            return list.stream().map(diaryMapper::toDto).collect(Collectors.toList());
        }
        throw new OrdersExceptionBadRequest(MessageResource.DIARY_NOT_EXIST_RECORD.getValue());
    }

    @Override
    public DiaryDto findById(Long id) {
        Optional<Diary> optionSchool =  diaryRepository.findById(id);
        if(optionSchool.isPresent()){
            return optionSchool.map(diaryMapper::toDto).get();
        }
        throw new SchoolExceptionBadRequest(MessageResource.DIARY_NOT_EXIST_RECORDS.getValue());

    }
    @Override
    public List<DiaryDto> findByIdUser(Long idUser) {
        List<Diary> listDiary = diaryRepository.findByUserId(idUser);
        if(!listDiary.isEmpty()){
            return listDiary.stream().map(diaryMapper::toDto).collect(Collectors.toList());
        }
        throw new OrdersExceptionBadRequest(MessageResource.USER_NOT_EXIST_RECORD.getValue());
    }
    private Users validateUsersById(Long id, String message) {
        return usersRepository.findById(id).orElseThrow(() -> new DiaryExceptionBadRequest(message));
    }

    private School validateSchoolById(Long id, String message){
        return schoolRepository.findById(id).orElseThrow(() -> new DiaryExceptionBadRequest(message));
    }

    private boolean validaWeekday(int weekday) {
        return (weekday>=1 && weekday<=7);
    }

    private void validateTime(LocalTime startTime,LocalTime endTime){
        if (startTime.isAfter(endTime)){
            throw new DiaryExceptionBadRequest(MessageResource.DIARY_TIME_START_INVALID_NOT_SAVE.getValue());
        }
        if(endTime.isBefore(startTime)){
            throw new DiaryExceptionBadRequest(MessageResource.DIARY_TIME_ENDING_INVALID_NOT_SAVE.getValue());
        }
    }

    private void validateDiary(long id, String message){
        diaryRepository.findById(id).orElseThrow(()-> new DiaryExceptionBadRequest(message));
    }

    private void validateDiaryFields(DiaryDto diaryDto){
        validateTime(diaryDto.getStartTime(),diaryDto.getEndingTime());
        if(!validaWeekday(diaryDto.getWeekday())){
            throw new DiaryExceptionBadRequest(MessageResource.DIARY_WEEKDAY_INVALID_NOT_SAVE.getValue());
        }

        String replacement = diaryDto.getReplacement();
        if(!replacement.contentEquals("0") && !replacement.contentEquals("1")){
            throw new DiaryExceptionBadRequest(MessageResource.DIARY_REPLACEMENT_INVALID_NOT_SAVE.getValue());
        }
    }

}
