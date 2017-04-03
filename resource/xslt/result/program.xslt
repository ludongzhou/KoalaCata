<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <Program>
                <Title>
                    <ProperTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/ProperTitle"/>
                    </ProperTitle>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Title/ParallelProperTitle">
                        <ParallelProperTitle>
                            <xsl:value-of select="current()"/>
                        </ParallelProperTitle>
                    </xsl:for-each>
                    <SubordinateTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/SubordinateTitle"/>
                    </SubordinateTitle>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Title/AlternativeTitle">
                        <AlternativeTitle>
                            <xsl:value-of select="current()"/>
                        </AlternativeTitle>
                    </xsl:for-each>
                    <TitleDescription>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/TitleDescription"/>
                    </TitleDescription>
                    <Series>
                        <SeriesTitle>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/SeriesTitle"/>
                        </SeriesTitle>
                        <xsl:for-each select="CMS/MetaData/Description/Program/Title/Series/ParallelSeriesTitle">
                            <ParallelSeriesTitle>
                                <xsl:value-of select="current()"/>
                            </ParallelSeriesTitle>
                        </xsl:for-each>
                        <TotalNumberofEpisodes>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/TotalNumberofEpisodes"/>
                        </TotalNumberofEpisodes>
                        <EpisodesNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/EpisodesNumber"/>
                        </EpisodesNumber>
                    </Series>
                </Title>
                <Subject>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Subject/Class">
                        <Class>
                            <Classification>
                                <xsl:value-of select="Classification"/>
                            </Classification>
                            <ClassNumber>
                                <xsl:value-of select="ClassNumber"/>
                            </ClassNumber>
                        </Class>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Subject/SubjectTerm">
                        <SubjectTerm>
                            <xsl:value-of select="current()"/>
                        </SubjectTerm>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Subject/Keyword">
                        <Keyword>
                            <xsl:value-of select="current()"/>
                        </Keyword>
                    </xsl:for-each>
                </Subject>
                <Description>
                    <DescriptionofContent>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/DescriptionofContent"/>
                    </DescriptionofContent>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/Character">
                        <Character>
                            <xsl:value-of select="current()"/>
                        </Character>
                    </xsl:for-each>
                    <DateofEvent>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/DateofEvent"/>
                    </DateofEvent>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/VersionDescription">
                        <VersionDescription>
                            <xsl:value-of select="current()"/>
                        </VersionDescription>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/Awards">
                        <Awards>
                            <NameofAwards>
                                <xsl:value-of select="NameofAwards"/>
                            </NameofAwards>
                            <ItemofAwards>
                                <xsl:value-of select="ItemofAwards"/>
                            </ItemofAwards>
                            <xsl:for-each select="WinnersofAwards">
                                <WinnersofAwards>
                                    <xsl:value-of select="current()"/>
                                </WinnersofAwards>
                            </xsl:for-each>
                            <YearorTimeofAwards>
                                <xsl:value-of select="YearorTimeofAwards"/>
                            </YearorTimeofAwards>
                            <DateofAwards>
                                <xsl:value-of select="DateofAwards"/>
                            </DateofAwards>
                        </Awards>
                    </xsl:for-each>

                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/Column">
                        <Column>
                            <ColumnName>
                                <xsl:value-of select="ColumnName"/>
                            </ColumnName>
                            <IssueNumber>
                                <xsl:value-of select="IssueNumber"/>
                            </IssueNumber>
                            <IssueYear>
                                <xsl:value-of select="IssueYear"/>
                            </IssueYear>
                        </Column>
                    </xsl:for-each>
                    <Audience>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/Audience"/>
                    </Audience>
                    <AdditionalLogo>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/AdditionalLogo"/>
                    </AdditionalLogo>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/AudioChannel">
                        <AudioChannel>
                            <AudioChannelNumber>
                                <xsl:value-of select="AudioChannelNumber"/>
                            </AudioChannelNumber>
                            <AudioChannelDescription>
                                <xsl:value-of select="AudioChannelDescription"/>
                            </AudioChannelDescription>
                        </AudioChannel>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Description/Attachment">
                        <Attachment>
                            <xsl:value-of select="current()"/>
                        </Attachment>
                    </xsl:for-each>
                </Description>
                <Creator>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Creator/DescriptionofCreator">
                        <DescriptionofCreator>
                            <NameofCreator>
                                <xsl:value-of select="NameofCreator"/>
                            </NameofCreator>
                            <xsl:for-each select="ParallelNameofCreator">
                                <ParallelNameofCreator>
                                    <xsl:value-of select="current()"/>
                                </ParallelNameofCreator>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofCreator>
                    </xsl:for-each>
                </Creator>
                <Contributor>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Contributor/DescriptionofContributor">
                        <DescriptionofContributor>
                            <NameofContributor>
                                <xsl:value-of select="NameofContributor"/>
                            </NameofContributor>
                            <xsl:for-each select="ParallelNameofContributor">
                                <ParallelNameofContributor>
                                    <xsl:value-of select="current()"/>
                                </ParallelNameofContributor>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofContributor>
                    </xsl:for-each>
                </Contributor>
                <Publisher>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Publisher/DescriptionofPublisher">
                        <DescriptionofPublisher>
                            <NameofPublisher>
                                <xsl:value-of select="NameofPublisher"/>
                            </NameofPublisher>
                            <PlaceofPublication>
                                <xsl:value-of select="MetaData.Program.Publisher.DescriptionofPublisher.PlaceofPublication"/>
                            </PlaceofPublication>
                        </DescriptionofPublisher>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Publisher/DescriptionofProducer">
                        <DescriptionofProducer>
                            <NameofProducer>
                                <xsl:value-of select="NameofProducer"/>
                            </NameofProducer>
                            <PlaceofProduction>
                                <xsl:value-of select="PlaceofProduction"/>
                            </PlaceofProduction>
                        </DescriptionofProducer>
                    </xsl:for-each>
                </Publisher>
                <Copyright>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Copyright/DescriptionofAuthorizedUse">
                        <DescriptionofAuthorizedUse>
                            <TimesofAuthorizedUsage>
                                <xsl:value-of select="TimesofAuthorizedUsage"/>
                            </TimesofAuthorizedUsage>
                        </DescriptionofAuthorizedUse>
                    </xsl:for-each>
                </Copyright>
                <Language>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Language/AudioChannel">
                        <AudioChannel>
                            <AudioChannelNumber>
                                <xsl:value-of select="AudioChannelNumber"/>
                            </AudioChannelNumber>
                            <AudioChannelLanguage>
                                <xsl:value-of select="MetaData.Program.Language.AudioChannel.AudioChannelLanguage"/>
                            </AudioChannelLanguage>
                        </AudioChannel>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Language/Subtitle">
                        <Subtitle>
                            <SubtitleNumber>
                                <xsl:value-of select="SubtitleNumber"/>
                            </SubtitleNumber>
                            <SubtitleLanguage>
                                <xsl:value-of select="SubtitleLanguage"/>
                            </SubtitleLanguage>
                        </Subtitle>
                    </xsl:for-each>
                </Language>
                <Date>
                    <ProducedDate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/ProducedDate"/>
                    </ProducedDate>
                    <DateofDebut>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/Debut/DateofDebut"/>
                    </DateofDebut>
                    <PublishedDate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/PublishedDate"/>
                    </PublishedDate>
                </Date>
                <Type>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Type/ProgramType">
                        <ProgramType>
                            <xsl:value-of select="current()"/>
                        </ProgramType>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Type/ProgramForm">
                        <ProgramForm>
                            <xsl:value-of select="current()"/>
                        </ProgramForm>
                    </xsl:for-each>
                </Type>
                <Format>
                    <Duration>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/Duration"/>
                    </Duration>
                    <StartingPoint>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/StartingPoint"/>
                    </StartingPoint>
                    <Color>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/Color"/>
                    </Color>
                    <SubtitleForm>
                        <xsl:value-of select="MetaData.Program.Format.SubtitleForm"/>
                    </SubtitleForm>
                    <AudioChannelFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioChannelFormat"/>
                    </AudioChannelFormat>
                    <AudioQuality>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioQuality"/>
                    </AudioQuality>
                    <VideoQuality>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoQuality"/>
                    </VideoQuality>
                    <AspectRatio>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AspectRatio"/>
                    </AspectRatio>
                    <PhysicalMediaType>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/PhysicalMediaType"/>
                    </PhysicalMediaType>
                    <System>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/System"/>
                    </System>
                    <AudioDataRate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioDataRate"/>
                    </AudioDataRate>
                    <AudioCodingFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioCodingFormat"/>
                    </AudioCodingFormat>
                    <AudioSamplingFrequency>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioSamplingFrequency"/>
                    </AudioSamplingFrequency>
                    <AudioBitDepth>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioBitDepth"/>
                    </AudioBitDepth>
                    <VideoBitrate>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/bitrate"/>
                    </VideoBitrate>
                    <VideoCodingFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoCodingFormat"/>
                    </VideoCodingFormat>
                    <VideoSamplingType>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoSamplingType"/>
                    </VideoSamplingType>
                    <FileFormat>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipFiles/ClipFile/ClipFileInfo/format"/>
                    </FileFormat>
                </Format>
                <Coverage>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Coverage/YearsCovered">
                        <YearsCovered>
                            <YearofStart>
                                <xsl:value-of select="YearofStart"/>
                            </YearofStart>
                            <YearofEnd>
                                <xsl:value-of select="YearofEnd"/>
                            </YearofEnd>
                        </YearsCovered>
                    </xsl:for-each>
                    <xsl:for-each select="CMS/MetaData/Description/Program/Coverage/Spatial">
                        <Spatial>
                            <xsl:value-of select="current()"/>
                        </Spatial>
                    </xsl:for-each>
                </Coverage>
            </Program>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>