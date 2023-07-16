import React from 'react';
import { useForm } from 'react-hook-form';


interface Member {
	email: string;
    authNumber: number;
    password: string;
}

const RegisterPage = () => {
  const { register, handleSubmit, formState: { errors } , reset} = useForm<Member>();


  const onSubmit = (data: Member) => {
    console.log('Member:', data);
    reset();
  };


  return (
    <>
      <h1>회원가입</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label>
          <p>학교 이메일 입력하기</p>
          <input
            className=" absolute bg-gray-300"
            type="email"
            {...register('email', { required: '이메일을 입력하세요' })}
          />
        </label>
        <br />
        <label>
          <p>인증번호 입력하기</p>
          <input 
            className="absolute bg-gray-300"
            type="text"
            {...register('authNumber', { required: '인증번호를 입력해주세요'})}
          />
        </label>
        <br />
        <label>
          <p>비밀번호 입력하기</p>
          <input
            className=" absolute bg-gray-300"
            type="password"
            {...register('password', { 
                required: '비밀번호를 입력', 
                    minLength:{
                        value: 6,
                        message: '비밀번호는 최소 6자리입니다.',
                    },
                })}
          />
        </label>
        <br />
        <p>{errors?.email?.message || errors?.authNumber?.message ||errors?.password?.message}</p>
        <button type="submit">회원가입</button>
        <button type="reset">취소</button>
      </form>
    </>
  );
};

export default RegisterPage;