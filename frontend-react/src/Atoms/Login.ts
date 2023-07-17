import { atom } from 'recoil';

export interface ILogin {
	id: string;
	password: string;
}

export const LoginState = atom<ILogin>({
	key: 'loginInfo',
	default: {
		id: '',
		password: '',
	}
});