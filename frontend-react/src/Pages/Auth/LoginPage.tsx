import { useNavigate } from "react-router-dom";
import { LoginState } from "../../Atoms/Login";
import { useRecoilState } from "recoil";
import { fetchLogin } from "../../Api/api";
import { useMutation } from "react-query";
import { useState } from "react";


const LoginPage = () => {
	const [id, setId] = useState("");
	const [password, setPassword] = useState("");
	const [loginState, setLoginState] = useRecoilState(LoginState);
	const navigate = useNavigate();
	const loginMutation = useMutation(() => fetchLogin(id, password), {
		 onSuccess: () => {
			setLoginState({ id: id, password: password });
			navigate('/');
		},
		onError: () => {
			alert("로그인에 실패했습니다.");
		}
	});
	
	const onSubmit = (e: any) => {
		e.preventDefault();
		// 전처리
		if (!id) {
		  return alert("ID를 입력하세요.");
		}
		else if (!password) {
		  return alert("Password를 입력하세요.");
		}
		loginMutation.mutate();
	};

    return (
		<div>
			<h1>로그인 페이지</h1>
			<form onSubmit={onSubmit}>
				<input type='text' 
						id='id'
						value={id} 
						onChange={ (e) => setId(e.target.value) } 
				/>
				<input type='password'
						id='password'
						value={password}
						onChange={ (e) => setPassword(e.target.value) }
				/>
			</form>
			<button type="submit" disabled={loginMutation.isLoading}>
				로그인
			</button>
		</div>
    );
};

export default LoginPage;
