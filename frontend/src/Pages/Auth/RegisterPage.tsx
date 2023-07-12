import React from 'react';
import { useForm } from 'react-hook-form';

interface Member {
  name: string;
  id: string;
  password: string;
}

const RegisterPage: React.FC = () => {
  const { register, handleSubmit, formState: { errors } , reset} = useForm<Member>();


  const onSubmit = (data: Member) => {
    console.log('Member:', data);
    reset();
  };


  return (
    <>
      <h2>회원가입</h2>
      <form onSubmit={handleSubmit(onSubmit)}>
        <label>
          아이디:
          <input
            type="text"
            {...register('name', { required: '이름을 입력하세요' })}
          />
        </label>
        <br />
        <label>
          ID:
          <input
            type="id"
            {...register('id', { required: '아이디를 입력해주세요'})}
          />
        </label>
        <br />
        <label>
          비밀번호:
          <input
            type="password"
            {...register('password', { 
                required: '비밀번호를 입력해주세요', 
                    minLength:{
                        value: 6,
                        message: '비밀번호는 최소 6자리입니다.',
                    },
                })}
          />
        </label>
        <br />
        <p>{errors?.name?.message || errors?.id?.message ||errors?.password?.message}</p>
        <button type="submit">Register</button>
      </form>
    </>
  );
};

export default RegisterPage;