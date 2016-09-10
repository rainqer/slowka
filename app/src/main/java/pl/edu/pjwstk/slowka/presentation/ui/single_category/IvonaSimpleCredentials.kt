package pl.edu.pjwstk.slowka.presentation.ui.single_category

import com.amazonaws.auth.AWSCredentials

class IvonaSimpleCredentials : AWSCredentials {

    override fun getAWSSecretKey(): String {
        return "IXbXhEbliFpAg2KJpb7Z9xPKod3114Vtuz8WYKHv"
    }

    override fun getAWSAccessKeyId(): String {
        return "GDNAJMY7WTBH24DRKQEQ"
    }

}
