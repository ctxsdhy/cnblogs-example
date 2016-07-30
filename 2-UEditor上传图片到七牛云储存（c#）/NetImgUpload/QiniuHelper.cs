using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using Qiniu.IO;
using Qiniu.RS;

namespace NetImgUpload
{
    /// <summary>
    /// 七牛工具类
    /// </summary>
    public class QiniuHelper
    {
        /// <summary>
        /// 空间名
        /// </summary>
        private static readonly string Scope = ConfigurationManager.AppSettings["QiniuScope"];

        /// <summary>
        /// 域名
        /// </summary>
        private static readonly string Url = ConfigurationManager.AppSettings["QiniuUrl"];

        /// <summary>
        /// 插入数据并返回交互结果
        /// </summary>
        /// <param name="imageFile"></param>
        /// <returns></returns>
        public static PutRet GetResult(byte[] imageFile)
        {
            var target = new IOClient();
            var extra = new PutExtra
            {
                MimeType = "text/plain",
                Crc32 = 123,
                CheckCrc = CheckCrcType.CHECK,
                Params = new Dictionary<string, string>()
            };
            var put = new PutPolicy(Scope);
            return target.Put(put.Token(), Guid.NewGuid().ToString(), new MemoryStream(imageFile), extra);
        }

        /// <summary>
        /// 获得url地址
        /// </summary>
        /// <returns></returns>
        public static string GetUrl(string key)
        {
            return GetPolicy.MakeBaseUrl(Url, key);
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <param name="key"></param>
        public static void DeleteData(string key)
        {
            var client = new RSClient();
            client.Delete(new EntryPath(Scope, key));
        }

        /// <summary>
        /// 批量删除数据
        /// </summary>
        /// <param name="keys"></param>
        public static void DeleteDatas(string keys)
        {
            var client = new RSClient();
            var entryPaths = new List<EntryPath>();
            foreach (string key in keys.Split(','))
            {
                entryPaths.Add(new EntryPath(Scope, key.Replace("'", "")));
            }
            client.BatchDelete(entryPaths.ToArray());
        }
    }
}
